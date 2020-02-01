package com.mall.parking.charging.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.service.ChargingRuleService;
import com.mall.parking.charging.service.RedisService;
import com.mall.parking.common.bean.ParkingConstant;

/**
 * @author https://backkoms.github.io/
 *
 */
@Component
@Order(value = 1)
public class StartUpApplicationRunner implements ApplicationRunner {

	@Autowired
	RedisService redisService;

	@Autowired
	ChargingRuleService ruleService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<ChargingRule> rules = ruleService.list();
		if (!redisService.exist(ParkingConstant.cache.chargingRule)) {
			redisService.cacheObject(ParkingConstant.cache.chargingRule, JSONObject.toJSONString(rules));
		}
	}
}
