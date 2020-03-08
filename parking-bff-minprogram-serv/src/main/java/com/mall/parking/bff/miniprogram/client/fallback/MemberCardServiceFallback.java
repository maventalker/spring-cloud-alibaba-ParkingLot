package com.mall.parking.bff.miniprogram.client.fallback;

import com.mall.parking.bff.miniprogram.client.MemberCardClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.exception.BusinessException;

public class MemberCardServiceFallback implements MemberCardClient {

	@Override
	public CommonResult<MemberCard> get(String memberId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
