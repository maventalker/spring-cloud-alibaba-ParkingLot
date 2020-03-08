package com.mall.parking.member.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.carwash.api.bean.CarWash;
import com.mall.parking.carwash.api.itf.WashService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Vehicle;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 */
@RestController
@RequestMapping("vehicle")
@Slf4j
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@Reference
	WashService washService;

	/**
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult<Integer> addVehicle(String json) throws BusinessException {
		log.debug("add vehicle = " + json);
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = vehicleService.addVehicle(json);
		result.setRespData(rtn);
		return result;

	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public CommonResult<Vehicle> get(String memberId) throws BusinessException {
		log.debug("add vehicle = " + memberId);
		CommonResult<Vehicle> result = new CommonResult<>();
		Vehicle rtn = vehicleService.getVehicle(memberId);
		result.setRespData(rtn);
		return result;

	}

	/**
	 * {"plateNo":"湘AG7890","ticketCode":"Ts0999"}
	 * 
	 * @param json
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/wash")
	public CommonResult<Integer> wash(String json) throws BusinessException {
		log.debug("add vehicle = " + json);
		CommonResult<Integer> result = new CommonResult<>();
		
		int rtn = washService.wash(json);
		result.setRespData(rtn);
		return result;

	}

	public static void main(String[] args) {
		CarWash wash = new CarWash();
		wash.setPlateNo("湘AG7890");
		wash.setTicketCode("Ts0999");
		log.info(JSONObject.toJSONString(wash));
	}
}
