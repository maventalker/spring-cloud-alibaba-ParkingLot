package com.mall.parking.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.finance.entity.Billing;
import com.mall.parking.finance.mapper.BillingMapper;
import com.mall.parking.finance.service.BillService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillingMapper billMapper;
	
	@Override
	public int create(String json) {
		Billing bill = JSONObject.parseObject(json, Billing.class);
		log.info("analysis billing data = " +json);
		return billMapper.insertSelective(bill);
	}

}
