package com.mall.parking.bff.nativeapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.bff.nativeapp.client.fallback.MemberServiceFallback;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;
import com.mall.parking.common.entity.Vehicle;

/**
 * @author https://backkoms.github.io/
 *
 */
@FeignClient(value = "member-service", fallback = MemberServiceFallback.class)
public interface MemberServiceClient {

	
	@RequestMapping(value = "/member/getMember", method = RequestMethod.POST)
	public CommonResult<Member> getMemberInfo(@RequestParam(value = "memberId") String memberId);

	@RequestMapping(value = "/vehicle/get", method = RequestMethod.POST)
	public CommonResult<Vehicle> getVehicle(@RequestParam(value = "memberId") String memberId);
}
