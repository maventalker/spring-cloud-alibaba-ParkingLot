package com.mall.parking.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.service.MonthCardService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@RestController
@RequestMapping("monthcard")
@Slf4j
public class MonthCardController {

	@Autowired
	MonthCardService cardService;

	/**
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult<Integer> addMonthCard(String json) throws BusinessException{
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = cardService.addMonthCard(json);
		log.debug("add month card success " + json);
		result.setRespData(rtn);
		return result;
	}

	/**
	 * @param vehicleNo
	 * @return
	 */
	@RequestMapping(value = "isMonthCardUser",method = RequestMethod.POST)
	public CommonResult<Boolean> isMonthCardUser(String vehicleNo) throws BusinessException{
		CommonResult<Boolean> result = new CommonResult<>();
		boolean flag = cardService.isMonthCardUser(vehicleNo);
		result.setRespData(flag);
		return result;
	}
}
