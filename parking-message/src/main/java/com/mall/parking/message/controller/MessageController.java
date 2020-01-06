package com.mall.parking.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.message.service.messageService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RestController
@RequestMapping("msg")
@Slf4j
public class MessageController {

	@Autowired
	messageService messageService;

	@PostMapping("/sendNotice")
	public CommonResult<Integer> sendNotice(String json) throws BusinessException {
		log.info("get msg = " + json);
		CommonResult<Integer> commonResult = new CommonResult<>();
		int rtn = messageService.sendNotice(json);
		commonResult.setRespData(rtn);
		return commonResult;
	}
}
