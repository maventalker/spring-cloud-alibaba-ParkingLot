package com.mall.parking.charging.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.client.BillFeignClient;
import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.entity.Entrance;
import com.mall.parking.charging.entity.EntranceExample;
import com.mall.parking.charging.entity.Exists;
import com.mall.parking.charging.mapper.EntranceMapper;
import com.mall.parking.charging.mapper.ExistsMapper;
import com.mall.parking.charging.service.ExistsService;
import com.mall.parking.charging.service.RedisService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.common.entity.Billing;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class ExistsServiceImpl implements ExistsService {

	@Autowired
	ExistsMapper existsMapper;

	@Autowired
	EntranceMapper entranceMapper;

	@Autowired
	RedisService redisService;

	@Autowired
	BillFeignClient billFeignClient;

	@Override
	public int createExsits(String json) throws BusinessException {
		log.info("exists data = " + json);
		Exists exists = JSONObject.parseObject(json, Exists.class);
		int rtn = existsMapper.insertSelective(exists);

		// calu fee
		EntranceExample entranceExample = new EntranceExample();
		entranceExample.setOrderByClause("create_date desc limit 0,1");
		entranceExample.createCriteria().andPlateNoEqualTo(exists.getPlateNo());
		List<Entrance> entrances = entranceMapper.selectByExample(entranceExample);
		Entrance lastEntrance = null;
		if (CollectionUtils.isNotEmpty(entrances)) {
			lastEntrance = entrances.get(0);
		}
		if (null == lastEntrance) {
			throw new BusinessException("异常车辆，未找到入场数据!");
		}
		Instant entryTime = lastEntrance.getCreateDate().toInstant();
		Duration duration = Duration.between(LocalDateTime.ofInstant(entryTime, ZoneId.systemDefault()),
				LocalDateTime.now());
		long mintues = duration.toMinutes();
		float fee = caluateFee(mintues);

		// invoke thridPay service to pay the fee
		Billing billing = new Billing();
		billing.setFee(fee);
		billing.setDuration(Float.valueOf(mintues));
		billing.setPlateNo(exists.getPlateNo());
		CommonResult<Integer> createRtn = billFeignClient.create(JSONObject.toJSONString(billing));
		if (createRtn.getRespData() > 0) {
			log.info("billing suc!");
		}

		// make event to invoke electric screen update

		// send user message
		return rtn;
	}

	/**
	 * @param stayMintues
	 * @return
	 */
	private float caluateFee(long stayMintues) {
		String ruleStr = (String) redisService.getkey(ParkingConstant.cache.chargingRule);
		JSONArray array = JSONObject.parseArray(ruleStr);
		List<ChargingRule> rules = JSONObject.parseArray(array.toJSONString(), ChargingRule.class);
		float fee = 0;
		for (ChargingRule chargingRule : rules) {
			if (chargingRule.getStart() <= stayMintues && chargingRule.getEnd() > stayMintues) {
				fee = chargingRule.getFee();
				break;
			}
		}
		return fee;
	}

}
