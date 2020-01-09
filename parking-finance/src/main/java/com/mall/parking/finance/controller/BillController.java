package com.mall.parking.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.finance.service.BillService;

@RestController
@RequestMapping("billing")
public class BillController {

	@Autowired
	BillService billService;

	@PostMapping("/create")
	public CommonResult<Integer> create(String json) throws BusinessException {
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = billService.create(json);
		result.setRespData(rtn);
		return result;
	}
}
