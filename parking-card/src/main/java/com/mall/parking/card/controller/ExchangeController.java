package com.mall.parking.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.card.entity.Exchange;
import com.mall.parking.card.service.ExchangeService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RequestMapping("exchange")
@RestController
@Slf4j
public class ExchangeController {

	@Autowired
	ExchangeService exchangeService;

	/**
	 * example : {"cardQty":100,"code":"v394","ctype":0}
	 * 
	 * @param json
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult<Integer> exchange(String json) throws BusinessException {
		log.debug("create exchage  = " + json);
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = exchangeService.createExchange(json);
		result.setRespData(rtn);
		return result;
	}

	public static void main(String[] args) {
		Exchange exchange = new Exchange();
		exchange.setCardQty(100);
		exchange.setCode("v394");
		exchange.setCtype(1);

		log.info(JSONObject.toJSONString(exchange));
	}
}
