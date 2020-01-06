package com.mall.parking.charging.service;

public interface RedisService {

	boolean exist(String chargingrule);

	void cacheObject(String chargingrule, String jsonString);

}
