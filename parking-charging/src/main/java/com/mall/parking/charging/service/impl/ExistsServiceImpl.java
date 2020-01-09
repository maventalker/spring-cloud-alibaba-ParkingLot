package com.mall.parking.charging.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.client.BillFeignClient;
import com.mall.parking.charging.client.MessageClient;
import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.entity.Entrance;
import com.mall.parking.charging.entity.EntranceExample;
import com.mall.parking.charging.entity.Exists;
import com.mall.parking.charging.mapper.EntranceMapper;
import com.mall.parking.charging.mapper.ExistsMapper;
import com.mall.parking.charging.service.ExistsService;
import com.mall.parking.charging.service.RedisService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.bean.Message;
import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.common.entity.Billing;
import com.mall.parking.common.exception.BusinessException;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class ExistsServiceImpl implements ExistsService {

	@Autowired
	ExistsMapper ExistsMapper;

	@Autowired
	EntranceMapper entranceMapper;

	@Autowired
	RedisService redisService;

	@Autowired
	BillFeignClient billFeignClient;

	@Autowired
	MessageClient messageClient;

	@Autowired
	Source source;

	@Override
	@Transactional(rollbackFor = Exception.class)
	@GlobalTransactional
	public int createExsits(String json) throws BusinessException {
		log.info("Exists data = " + json);
		Exists exists = JSONObject.parseObject(json, Exists.class);
		int rtn = ExistsMapper.insertSelective(exists);
		log.info("insert into park_charge.Exists data suc !");

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
		log.info("calu parking fee = " + fee);

		// invoke thridPay service to pay the fee
		Billing billing = new Billing();
		billing.setFee(fee);
		billing.setDuration(Float.valueOf(mintues));
		billing.setPlateNo(exists.getPlateNo());
		CommonResult<Integer> createRtn = billFeignClient.create(JSONObject.toJSONString(billing));
		if (createRtn.getRespCode() > 0) {
			log.info("insert into billing suc!");
		}else {
			throw new BusinessException("invoke finance service fallback...");
		}

		// make event to invoke electric screen update
		redisService.increase(ParkingConstant.cache.currentAviableStallAmt);
		log.info("update parkingLot aviable stall amt = " +redisService.getkey(ParkingConstant.cache.currentAviableStallAmt));
		// send user message
		Message message = new Message();
		message.setMcontent("this is simple message.");
		message.setMtype("pay");
		source.output().send(MessageBuilder.withPayload(JSONObject.toJSONString(message)).build());
		log.info("produce msg to apache rocketmq , parking-messge to consume the msg as a consumer...");

		// write message sended
		CommonResult<Integer> msgRtn = messageClient.sendNotice(JSONObject.toJSONString(message));
		if (msgRtn.getRespCode() > 0) {
			log.info("insert into park_message.message data suc!");
		}else {
			throw new BusinessException("invoke message service fallback ...");
		}
		
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
