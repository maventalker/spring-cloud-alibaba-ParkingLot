package com.mall.parking.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberCardClient memberCardClient;
	
//	@Value("${onoff_bindmobile}")
//	private boolean onoffBindmobile;
//	
//	@Value("${on_bindmobile_mulriple}")
//	private int onBindmobileMulriple;
//	
//	@PostMapping("/getFlag")
//	public CommonResult<Boolean> getFlag(){
//		CommonResult<Boolean> result = new CommonResult<>();
//		result.setRespData(onoffBindmobile);
//		return result;
//	}

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
	
	/**
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public CommonResult<Member> logout(String memberId) throws BusinessException{
		CommonResult<Member> result = new CommonResult<>();
		//jwt并不会自动失效，需要配置redis一同使用，使用方法：
		//退出时，将token置入缓存，在网关验证token时，同样需要到缓存中查找token，如果存在则证明token已主动失效，无法再使用
		//网关验证时，如果token过期，则是token自动过期，直接响应去登陆
		return result;
	}
}
