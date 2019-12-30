/**
 * 
 */
package com.mall.parking.member.service;

import java.util.List;

import com.mall.parking.member.entity.Member;

/**
 * @author apple
 *
 */
public interface MemberService {
	
	List<Member> list();

	int bindMobile(String json);

}
