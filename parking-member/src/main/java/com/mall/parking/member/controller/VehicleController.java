package com.mall.parking.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 See more at : https://xiaozhuanlan.com/msa-practice
 */
@RestController
@RequestMapping("vehicle")
@Slf4j
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	/**
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult<Integer> addVehicle(String json) throws BusinessException{
		log.debug("add vehicle = " + json);
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = vehicleService.addVehicle(json);
		result.setRespData(rtn);
		return result;

	}
}
