package com.mall.parking.charging.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.Exists;
import com.mall.parking.charging.mapper.ExistsMapper;
import com.mall.parking.charging.service.ExistsService;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class ExistsServiceImpl implements ExistsService {

	@Autowired
	ExistsMapper existsMapper;

	@Override
	public int createExsits(String json) throws BusinessException {
		log.info("exists data = " + json);
		Exists exists = JSONObject.parseObject(json, Exists.class);
		return existsMapper.insertSelective(exists);
	}

}
