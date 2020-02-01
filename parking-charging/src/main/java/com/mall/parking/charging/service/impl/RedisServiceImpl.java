package com.mall.parking.charging.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.mall.parking.charging.service.RedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
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

	@Override
	public Object getkey(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void decrease(String currentaviablestallamt) {
		redisTemplate.opsForValue().decrement(currentaviablestallamt);
	}
	
	@Override
	public void increase(String currentaviablestallamt) {
		redisTemplate.opsForValue().increment(currentaviablestallamt);		
	}


}
