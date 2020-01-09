package com.mall.parking.resource.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.resource.entity.StallExample;
import com.mall.parking.resource.mapper.StallMapper;
import com.mall.parking.resource.service.RedisService;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class StartUPCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	RedisService redisService;
	
	@Autowired
	StallMapper stallMapper;

	@Override
	public void run(String... args) throws Exception {
		//just init once
		if (!redisService.exist(ParkingConstant.cache.currentAviableStallAmt)) {
			StallExample example = new StallExample();
			long stalls = stallMapper.countByExample(example);
			redisService.cacheObject(ParkingConstant.cache.currentAviableStallAmt, stalls+"");
			log.info(ParkingConstant.cache.currentAviableStallAmt + " cached ... -------------->>>>><<<");
			
		}
	}

}
