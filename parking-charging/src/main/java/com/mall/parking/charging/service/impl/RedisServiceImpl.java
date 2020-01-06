package com.mall.parking.charging.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.mall.parking.charging.service.RedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Override
	public boolean exist(String chargingrule) {
		ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
		return valueOperations.get(chargingrule) != null ? true : false;
	}

	@Override
	public void cacheObject(String chargingrule, String jsonString) {
		redisTemplate.opsForValue().set(chargingrule, jsonString);
		log.info("chargingrule cached!");
	}

}
