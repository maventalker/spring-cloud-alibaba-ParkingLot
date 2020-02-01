package com.mall.parking.charging.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.Entrance;
import com.mall.parking.charging.mapper.EntranceMapper;
import com.mall.parking.charging.service.EntranceService;
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
public class EntranceServiceImpl implements EntranceService {
	@Autowired
	EntranceMapper entranceMapper;

	@Autowired
	RedisService redisService;

	@Override
	@Transactional
	public int createEntrance(String json) throws BusinessException {
		log.info("create entrance data = " + json);
		Entrance entrance = JSONObject.parseObject(json, Entrance.class);

		// decreate available stall amount
		redisService.decrease(ParkingConstant.cache.currentAviableStallAmt);
		log.info("decreate available stall amount = " + json);
		return entranceMapper.insertSelective(entrance);
	}
}
