package com.mall.parking.charging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.common.bean.Message;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RequestMapping("mq")
@RestController
@Slf4j
public class MQController {

	@Autowired
	Source source;

	@PostMapping("/sendTestMsg")
	public void sendTestMsg() {
		Message message = new Message();
		message.setMcontent("这是第一个消息测试.");
		message.setMtype("支付消息");
		source.output().send(MessageBuilder.withPayload(JSONObject.toJSONString(message)).build());
		log.info("send normal message suc");
	}

}
