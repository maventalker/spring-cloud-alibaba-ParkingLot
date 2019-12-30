package com.mall.parking.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.member.entity.Member;
import com.mall.parking.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author apple
 *
 */
@RestController
@RequestMapping("member")
@Slf4j
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/list")
	public List<Member> list() {
		List<Member> members = memberService.list();
		log.debug("query member list = " + members);
		return members;
	}

}
