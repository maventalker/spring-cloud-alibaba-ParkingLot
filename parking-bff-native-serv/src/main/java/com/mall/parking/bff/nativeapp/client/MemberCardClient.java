package com.mall.parking.bff.nativeapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.bff.nativeapp.client.fallback.MemberCardServiceFallback;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
@FeignClient(value = "card-service", fallback = MemberCardServiceFallback.class)
public interface MemberCardClient {

	@RequestMapping(value = "/card/get", method = RequestMethod.POST)
	public CommonResult<MemberCard> get(@RequestParam(value = "memberId") String memberId) throws BusinessException;

}
