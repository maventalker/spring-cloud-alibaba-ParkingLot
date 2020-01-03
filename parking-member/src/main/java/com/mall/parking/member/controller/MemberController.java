package com.mall.parking.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.client.MemberCardClient;
import com.mall.parking.member.entity.Member;
import com.mall.parking.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RestController
@RequestMapping("member")
@Slf4j
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberCardClient memberCardClient;

	/**
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public List<Member> list() throws BusinessException {
		List<Member> members = memberService.list();
		log.debug("query member list = " + members);
		return members;
	}

	/**
	 * bind user mobile
	 * {"birth":"2009-02-03","fullName":"tomsoon","phone":"13312345678"}
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/bindMobile", method = RequestMethod.POST)
	public CommonResult<Integer> bindMobile(String json) throws BusinessException{
		CommonResult<Integer> result = new CommonResult<>();
		log.info("bind mobile param = " + json);
		int rtn = memberService.bindMobile(json);
		result.setRespData(rtn);
		return result;
	}

	/**
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/getMember", method = RequestMethod.POST)
	public CommonResult<Member> getMemberInfo(String memberId) throws BusinessException{
		CommonResult<Member> result = new CommonResult<>();
		Member member = memberService.getMember(memberId);
		result.setRespData(member);
		return result;
	}
}
