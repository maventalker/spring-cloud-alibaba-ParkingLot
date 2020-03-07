package com.mall.parking.schedule.job.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.schedule.job.client.fallback.MemberServiceFallback;

/**
 * @author https://backkoms.github.io/
 *
 */
@FeignClient(value = "member-service", fallback = MemberServiceFallback.class)
public interface MemberServiceClient {

	@RequestMapping(value = "/member/list", method = RequestMethod.POST)
	public String list() throws BusinessException;
	
//	@RequestMapping(value = "/member/list", method = RequestMethod.POST)
//	public CommonResult<List<Member>> list() throws BusinessException;
	
	@RequestMapping(value = "/member/getMember", method = RequestMethod.POST)
	public CommonResult<Member> getMemberInfo(@RequestParam(value = "memberId") String memberId);

}
