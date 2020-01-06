package com.mall.parking.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.finance.entity.MonthCardRecharge;
import com.mall.parking.finance.mapper.MonthCardRechargeMapper;
import com.mall.parking.finance.service.MonthCardRechargeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class MonthCardRechageServiceImpl implements MonthCardRechargeService {

	@Autowired
	MonthCardRechargeMapper rechargeMapper;

	@Override
	public int create(String json) {
		MonthCardRecharge recharge = JSONObject.parseObject(json, MonthCardRecharge.class);
		log.info(" analysis recharge data = " + json);
		return rechargeMapper.insertSelective(recharge);
	}
}
