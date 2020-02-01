package com.mall.parking.member.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.client.fallback.MemberCardServiceFallback;

/**
 * @author https://backkoms.github.io/
 *
 */
@FeignClient(value = "card-service", fallback = MemberCardServiceFallback.class)
public interface MemberCardClient {

	@RequestMapping(value = "/card/addCard", method = RequestMethod.POST)
	public CommonResult<Integer> addCard(@RequestParam(value = "json") String json) throws BusinessException;

	@RequestMapping(value = "/card/updateCard", method = RequestMethod.POST)
	public CommonResult<Integer> updateCard(@RequestParam(value = "json") String json) throws BusinessException;
}
