package com.mall.parking.bff.miniprogram.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.bff.miniprogram.client.MemberServiceClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberServiceFallback implements MemberServiceClient{

	@Override
	public CommonResult<Member> getMemberInfo(String memberId) {
		log.warn("invoke member service error , just fallback now!");
		return null;
	}

}
