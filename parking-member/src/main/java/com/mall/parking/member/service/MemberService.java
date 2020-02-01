/**
 * 
 */
package com.mall.parking.member.service;

import java.util.List;

import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.entity.Member;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface MemberService {
	
	List<Member> list() throws BusinessException;

	int bindMobile(String json) throws BusinessException;

	Member getMember(String memberId) throws BusinessException;

}
