package com.mall.parking.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.finance.service.MonthCardRechargeService;

@RestController
@RequestMapping("recharge")
public class MonthCardRechageController {

	@Autowired
	MonthCardRechargeService rechargeService;

	@PostMapping("/create")
	public CommonResult<Integer> create(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>();
		int rtn = rechargeService.create(json);
		commonResult.setRespData(rtn);
		return commonResult;
	}
}
