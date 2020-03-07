/**
 * 
 */
package com.mall.parking.member.service;

import java.util.List;

import com.mall.parking.common.entity.Member;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface MemberService {
	
	List<Member> list() throws BusinessException;

	int bindMobile(String json) throws BusinessException;

	Member getMember(String memberId) throws BusinessException;

	int bindMobileUseRestTemplate(String json) throws BusinessException;

}
