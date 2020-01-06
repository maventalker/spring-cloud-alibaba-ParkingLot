package com.mall.parking.charging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.charging.service.ExistsService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RequestMapping("exists")
@RestController
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
}
