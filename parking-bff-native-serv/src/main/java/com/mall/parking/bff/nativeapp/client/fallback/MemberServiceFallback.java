package com.mall.parking.bff.nativeapp.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.bff.nativeapp.client.MemberServiceClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;
import com.mall.parking.common.entity.Vehicle;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberServiceFallback implements MemberServiceClient{

	@Override
	public CommonResult<Member> getMemberInfo(String memberId) {
		log.warn("invoke member service error , just fallback now!");
		return null;
	}

	@Override
	public CommonResult<Vehicle> getVehicle(String memberId) {
		return null;
	}

}
