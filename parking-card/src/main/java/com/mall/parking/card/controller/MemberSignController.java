package com.mall.parking.card.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.card.entity.MemberSign;
import com.mall.parking.card.service.MemberSignService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@RequestMapping("sign")
@RestController
@Slf4j
public class MemberSignController {

	@Autowired
	MemberSignService signService;

	/**
	 * {"cnt":10,"ctype":0,"memberId":"1231231231"}
	 * 
	 * @param json
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult<Integer> add(String json) throws BusinessException {
		log.info("member begin sign = " + json);
		/* 这里抛出异常是为了测试spring-cloud-gateway的retry机制是否正常运行
		 * if (StringUtils.isEmpty("")) {
			throw new BusinessException("test retry function");
		}*/
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = signService.sign(json);
		result.setRespData(rtn);
		return result;
	}

	public static void main(String[] args) {
		MemberSign sign = new MemberSign();
		sign.setMemberId("1231231231");
		sign.setCnt(10);
		sign.setCtype(0);
		log.info(JSONObject.toJSONString(sign));
	}
}
