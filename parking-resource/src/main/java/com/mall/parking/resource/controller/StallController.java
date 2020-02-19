package com.mall.parking.resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.bean.ParkingConstant;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.resource.entity.Stall;
import com.mall.parking.resource.service.RedisService;
import com.mall.parking.resource.service.StallService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@RestController
@RequestMapping("stall")
@Slf4j
public class StallController {

	@Autowired
	StallService stallService;
	
	@Autowired
	RedisService redisService;

	@PostMapping("/occupy")
	public CommonResult<Integer> occupy(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>();
		int rtn = stallService.occupy(json);
		commonResult.setRespData(rtn);
		return commonResult;
	}

	@PostMapping("/exist")
	public CommonResult<Integer> exist(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>();
		int rtn = stallService.exist(json);
		commonResult.setRespData(rtn);
		return commonResult;
	}
	
	@PostMapping("/list")
	public CommonResult<List<Stall>> list(String json) throws BusinessException {
		CommonResult<List<Stall>> commonResult = new CommonResult<>();
		List<Stall> rtn = stallService.list(json);
		commonResult.setRespData(rtn);
		return commonResult;
	}
	
	
	@PostMapping("/currentAviableStallAmt")
	public CommonResult<Integer> get()throws BusinessException{
		CommonResult<Integer> commonResult = new CommonResult<>();
		Object rtn = redisService.getkey(ParkingConstant.cache.currentAviableStallAmt);
		commonResult.setRespData(Integer.valueOf(rtn +""));
		return commonResult;
	}

}
