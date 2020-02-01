package com.mall.parking.card.service.impl;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.card.entity.Exchange;
import com.mall.parking.card.mapper.ExchangeMapper;
import com.mall.parking.card.service.ExchangeService;
import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {
	
	@Autowired
	ExchangeMapper exchangeMapper;

	@Autowired
	Redisson redisson;

	@Override
	public int createExchange(String json) throws BusinessException {
		Exchange exchange = JSONObject.parseObject(json, Exchange.class);
		int rtn = 0;
		// if request is coupon,use redisson to deal it
		if (exchange.getCtype() == 0) {
			RAtomicLong atomicLong = redisson.getAtomicLong(ParkingConstant.cache.grouponCodeAmtKey);
			// get lock
			RLock rLock = redisson.getLock(ParkingConstant.lock.exchangeCouponLock);
			rLock.lock(1000, TimeUnit.SECONDS);
			log.info("lock it when release ...");

			// just when coupon qty > 0 ,can exchange
			if (atomicLong.get() > 0) {
				rtn = exchangeMapper.insertSelective(exchange);
				atomicLong.decrementAndGet();
			}

			// release lock
			rLock.unlock();
			log.info("exchage coupon ended ...");
		} else {
			rtn = exchangeMapper.insertSelective(exchange);
		}
		log.debug("create exchage ok = " + exchange.getId());
		return rtn;
	}
}
