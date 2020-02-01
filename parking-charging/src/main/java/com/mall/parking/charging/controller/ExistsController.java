package com.mall.parking.charging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.Exists;
import com.mall.parking.charging.service.ExistsService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@RequestMapping("exists")
@RestController
@Slf4j
public class ExistsController {

	@Autowired
	ExistsService existsService;

	@PostMapping("/create")
	public CommonResult<Integer> create(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>();
		int rtn = existsService.createExsits(json);
		commonResult.setRespData(rtn);
		return commonResult;
	}
	
	public static void main(String[] args) {
		Exists Leave = new Exists();
		Leave.setPlateNo("ddddd");
		Leave.setBrakeId("2323");
		log.info(JSONObject.toJSONString(Leave));
	}
}
