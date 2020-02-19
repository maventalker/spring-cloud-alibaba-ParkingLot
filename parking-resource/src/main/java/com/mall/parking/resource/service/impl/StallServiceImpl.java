package com.mall.parking.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.resource.entity.Stall;
import com.mall.parking.resource.entity.StallExample;
import com.mall.parking.resource.entity.StallParked;
import com.mall.parking.resource.mapper.StallMapper;
import com.mall.parking.resource.mapper.StallParkedMapper;
import com.mall.parking.resource.service.RedisService;
import com.mall.parking.resource.service.StallService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StallServiceImpl implements StallService {

	@Autowired
	StallMapper stallMapper;

	@Autowired
	StallParkedMapper stallPardedMapper;
	
	@Autowired
	RedisService redisService;

	@Override
	@Transactional
	public int occupy(String json) {
		StallParked stallParked = JSONObject.parseObject(json, StallParked.class);
		log.info("stall parked data = " + json);

		// update stall status
		StallExample example = new StallExample();
		example.createCriteria().andIdEqualTo(stallParked.getStallId());
		Stall updateStall = new Stall();
		updateStall.setId(stallParked.getStallId());
		updateStall.setIsParked(1);
		stallMapper.updateByExampleSelective(updateStall, example);
		log.info(" parked stall = " +json);

		return stallPardedMapper.insertSelective(stallParked);
	}

	@Override
	@Transactional
	public int exist(String json) {
		StallParked stallParked = JSONObject.parseObject(json, StallParked.class);
		log.info("stall exist data = " + json);

		// update stall unparked status
		StallExample example = new StallExample();
		example.createCriteria().andIdEqualTo(stallParked.getStallId());
		Stall updateStall = new Stall();
		updateStall.setId(stallParked.getStallId());
		updateStall.setIsParked(0);
		stallMapper.updateByExampleSelective(updateStall, example);
		log.info("release stall  = " +json);

		
		//decrease available stall amount
		redisService.increase(ParkingConstant.cache.currentAviableStallAmt);
		return stallPardedMapper.updateByPrimaryKey(stallParked);
	}

	@Override
	public List<Stall> list(String json) {
		StallExample example = new StallExample();
		List<Stall> list = stallMapper.selectByExample(example);
		return list;
	}

}
