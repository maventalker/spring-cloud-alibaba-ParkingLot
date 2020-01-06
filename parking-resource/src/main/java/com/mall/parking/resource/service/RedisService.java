package com.mall.parking.resource.service;

public interface RedisService {

	boolean exist(String chargingrule);

	void cacheObject(String chargingrule, String jsonString);

	Object getkey(String key);

	void decrease(String currentaviablestallamt);

	void increase(String currentaviablestallamt);
}
