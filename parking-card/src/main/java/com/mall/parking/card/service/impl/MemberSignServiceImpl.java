package com.mall.parking.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.card.entity.MemberSign;
import com.mall.parking.card.mapper.MemberSignMapper;
import com.mall.parking.card.service.MemberSignService;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service
@Slf4j
public class MemberSignServiceImpl implements MemberSignService {

	@Autowired
	MemberSignMapper signMapper;

	@Override
	public int sign(String json) throws BusinessException {
		MemberSign sign = JSONObject.parseObject(json,MemberSign.class);
		log.debug("sign service");
		return signMapper.insertSelective(sign);
	}
	
	
}
