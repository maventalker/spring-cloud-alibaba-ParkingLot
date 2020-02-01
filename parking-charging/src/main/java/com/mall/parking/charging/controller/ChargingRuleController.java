package com.mall.parking.charging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.service.ChargingRuleService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.bean.Message;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
@RequestMapping("chargingRule")
@RestController
public class ChargingRuleController {

	@Autowired
	ChargingRuleService chargingRuleService;
	
	@Autowired
	Source source;
	
	@PostMapping("/list")
	public List<ChargingRule> list() throws BusinessException{
		Message message = new Message();
		message.setMcontent("这是第一个消息测试.");
		message.setMtype("支付消息");
		source.output().send(MessageBuilder.withPayload(JSONObject.toJSONString(message)).build());
		return chargingRuleService.list();
	}
	
	/**
	 * when charging rule changed,use this method to refresh data to cache
	 * 
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/fresh")
	public CommonResult<Integer> refresh() throws BusinessException{
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = chargingRuleService.refresh();
		result.setRespData(rtn);
		return result;
	}
}
