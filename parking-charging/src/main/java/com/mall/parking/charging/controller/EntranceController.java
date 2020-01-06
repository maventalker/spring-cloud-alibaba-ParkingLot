package com.mall.parking.charging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.charging.entity.Entrance;
import com.mall.parking.charging.service.EntranceService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RequestMapping("entrance")
@RestController
@Slf4j
public class EntranceController {

	@Autowired
	EntranceService entranceService;
	
	
	@PostMapping("/create")
	public CommonResult<Integer> create(String json) throws BusinessException{
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = entranceService.createEntrance(json);
		result.setRespData(rtn);
		return result;
	}
	
	public static void main(String[] args) {
		Entrance entrance = new Entrance();
		entrance.setBrakeId("1212");
		entrance.setMemberId("23423423");
		entrance.setPlateNo("ddddd");
		log.info(JSONObject.toJSONString(entrance));
	}
}
