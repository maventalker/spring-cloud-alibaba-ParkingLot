package com.mall.parking.message.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.message.entity.Message;
import com.mall.parking.message.mapper.MessageMapper;
import com.mall.parking.message.service.messageService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class MessageServiceImpl implements messageService {

	@Autowired
	MessageMapper messageMapper;

	@Override
	public int sendNotice(String json) {
		log.info("message data = " + json);
		Message message = JSONObject.parseObject(json, Message.class);
		return messageMapper.insertSelective(message);
	}
	
	
	
}
