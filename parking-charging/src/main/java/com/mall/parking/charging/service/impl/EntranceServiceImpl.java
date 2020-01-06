package com.mall.parking.charging.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.Entrance;
import com.mall.parking.charging.mapper.EntranceMapper;
import com.mall.parking.charging.service.EntranceService;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class EntranceServiceImpl implements EntranceService {
	@Autowired
	EntranceMapper entranceMapper;

	@Override
	public int createEntrance(String json) throws BusinessException {
		log.info("create entrance data = " + json);
		Entrance entrance = JSONObject.parseObject(json, Entrance.class);
		return entranceMapper.insertSelective(entrance);
	}

}
