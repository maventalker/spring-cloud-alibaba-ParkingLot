package com.mall.parking.charging.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.entity.ChargingRuleExample;
import com.mall.parking.charging.mapper.ChargingRuleMapper;
import com.mall.parking.charging.service.ChargingRuleService;
import com.mall.parking.charging.service.RedisService;
import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service
@Slf4j
public class ChargingRuleServiceImpl implements ChargingRuleService {

	@Autowired
	ChargingRuleMapper ruleMapper;
	
	@Autowired
	RedisService redisService;

	@Override
	public List<ChargingRule> list() throws BusinessException {
		ChargingRuleExample example = new ChargingRuleExample();
		example.setOrderByClause("start asc");
		log.info("get charging rule suc!");
		return ruleMapper.selectByExample(example);
	}

	@Override
	public int refresh() {
		ChargingRuleExample example = new ChargingRuleExample();
		example.setOrderByClause("start asc");
		List<ChargingRule> list = ruleMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			redisService.cacheObject(ParkingConstant.cache.chargingRule, JSONObject.toJSONString(list));
			log.info("refresh chargingRule to redis cache ! ");
		}
		return 1;
	}

}
