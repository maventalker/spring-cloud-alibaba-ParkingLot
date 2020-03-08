package com.mall.parking.schedule.job.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.schedule.job.client.MemberServiceClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberServiceFallback implements MemberServiceClient {

	@Override
	public String list() throws BusinessException {
		String result = null;
		log.warn("member service not available! ");
		return result;
	}

	@Override
	public CommonResult<Member> getMemberInfo(String memberId) {
		CommonResult<Member> commonResult = new CommonResult<>("member-service getMemberInfo method not available!");
		log.warn("member-service getMemberInfo method not available!");
		commonResult.setRespData(null);
		return commonResult;
	}

//	@Override
//	public CommonResult<List<Member>> list() throws BusinessException {
//		CommonResult<List<Member>> commonResult = new CommonResult<>("member-service list method not available!");
//		log.warn("member-service list method not available!");
//		return commonResult;
//	}

}
