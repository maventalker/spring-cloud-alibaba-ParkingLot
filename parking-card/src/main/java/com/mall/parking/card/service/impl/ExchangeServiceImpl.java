package com.mall.parking.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.card.entity.Exchange;
import com.mall.parking.card.mapper.ExchangeMapper;
import com.mall.parking.card.service.ExchangeService;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {

	
	@Autowired
	ExchangeMapper exchangeMapper;

	@Override
	public int createExchange(String json) throws BusinessException{
		Exchange exchange = JSONObject.parseObject(json,Exchange.class);
		int rtn = exchangeMapper.insertSelective(exchange);
		log.debug("create exchage ok = " +exchange.getId());
		return rtn;
	}
}
