package com.mall.parking.bff.miniprogram.client.fallback;

import com.mall.parking.bff.miniprogram.client.MemberServiceClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;

public class MemberServiceFallback implements MemberServiceClient{

	@Override
	public CommonResult<Member> getMemberInfo(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
