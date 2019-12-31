package com.mall.parking.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.card.service.MemberSignService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RequestMapping("sign")
@RestController
@Slf4j
public class MemberSignController {

	@Autowired
	MemberSignService signService;
	
	@RequestMapping(value = "/addCard",method = RequestMethod.POST)
	public CommonResult<Integer> addCard(String json) throws BusinessException {
		log.debug(" begin add member card = " +json);
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = signService.sign(json);
		result.setRespData(rtn);
		return result;
	}
}
