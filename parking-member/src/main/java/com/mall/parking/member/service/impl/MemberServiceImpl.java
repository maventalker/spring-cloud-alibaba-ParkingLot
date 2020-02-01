package com.mall.parking.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.client.MemberCardClient;
import com.mall.parking.member.entity.Member;
import com.mall.parking.member.entity.MemberExample;
import com.mall.parking.member.mapper.MemberMapper;
import com.mall.parking.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service
@Slf4j
@Component
@RefreshScope
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	MemberCardClient memberCardClient;
	
	@Value("${onoff_bindmobile}")
	private boolean onoffBindmobile;
	
	@Value("${on_bindmobile_mulriple}")
	private int onBindmobileMulriple;

	@Override
	public List<Member> list() throws BusinessException{
		MemberExample example = new MemberExample();
		List<Member> members = memberMapper.selectByExample(example);
		return members;
	}

	@Override
	public int bindMobile(String json) throws BusinessException{
		Member member = JSONObject.parseObject(json, Member.class);
		int rtn = memberMapper.insertSelective(member);
		
		//invoke another service
		if (rtn > 0) {
			MemberCard card = new MemberCard();
			card.setMemberId(member.getId());
			if (onoffBindmobile) {
				//special logic
				card.setCurQty("" +50 * onBindmobileMulriple);
			}else {
				//normal logic
				card.setCurQty("50");
			}
			
			memberCardClient.addCard(JSONObject.toJSONString(card));
			log.info("creata member card suc!");
		}
		
		return rtn;
	}

	@Override
	public Member getMember(String memberId) throws BusinessException{
		return memberMapper.selectByPrimaryKey(memberId);
	}

	
	public static void main(String[] args) {
		Member member = new Member();
		member.setBirth("2009-02-03");
		member.setFullName("tomsoon");
		member.setPhone("13312345678");
		log.info(JSONObject.toJSONString(member));
	}
}
