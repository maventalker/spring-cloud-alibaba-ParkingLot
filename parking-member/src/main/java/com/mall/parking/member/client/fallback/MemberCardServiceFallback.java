package com.mall.parking.member.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.client.MemberCardClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberCardServiceFallback implements MemberCardClient {

	@Override
	public CommonResult<Integer> addCard(String json) throws BusinessException {
		CommonResult<Integer> result = new CommonResult<>("parking-card service not available! ");
		log.warn("parking-card service not available! ");
		return result;
	}

	@Override
	public CommonResult<Integer> updateCard(String json) throws BusinessException {
		CommonResult<Integer> result = new CommonResult<>("parking-card service not available! ");
		log.warn("parking-card service not available! ");
		return result;
	}

}
