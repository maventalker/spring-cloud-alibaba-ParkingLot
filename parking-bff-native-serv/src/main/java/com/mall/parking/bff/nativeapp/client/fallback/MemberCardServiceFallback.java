package com.mall.parking.bff.nativeapp.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.bff.nativeapp.client.MemberCardClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberCardServiceFallback implements MemberCardClient {

	@Override
	public CommonResult<MemberCard> get(String memberId) throws BusinessException {
		log.warn("invoke card service error , just fallback now!");
		return null;
	}

}
