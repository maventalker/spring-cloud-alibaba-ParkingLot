package com.mall.parking.bff.miniprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.bff.miniprogram.client.MemberCardClient;
import com.mall.parking.bff.miniprogram.client.MemberServiceClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.entity.Member;
import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.entity.MemberInfoVO;
import com.mall.parking.common.exception.BusinessException;

@RestController
@RequestMapping("bff/miniprogram/member")
public class APIMemberController {

	@Autowired
	MemberServiceClient memberServiceClient;
	
	@Autowired
	MemberCardClient memberCardClient;
	
	@PostMapping("/get")
	public CommonResult<MemberInfoVO> getMemberInfo(String memberId) throws BusinessException {
		CommonResult<MemberInfoVO> commonResult = new CommonResult<>();
		
		//service aggregation
		CommonResult<Member> member = memberServiceClient.getMemberInfo(memberId);
		CommonResult<MemberCard> card  = memberCardClient.get(memberId);
		
		MemberInfoVO vo = new MemberInfoVO();
		if (null != member.getRespData()) {
			vo.setId(member.getRespData().getId());
			vo.setPhone(member.getRespData().getPhone());
			vo.setFullName(member.getRespData().getFullName());
			vo.setBirth(member.getRespData().getBirth());
		}
		
		if (null != card.getRespData()) {
			vo.setCurQty(card.getRespData().getCurQty());
		}
		commonResult.setRespData(vo);
		return commonResult;
	}
}
