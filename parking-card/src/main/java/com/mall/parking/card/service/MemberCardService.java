package com.mall.parking.card.service;

import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface MemberCardService {

	/**
	 * 绑定手机时，增加会员积分
	 * 
	 * @param json
	 * @return
	 * @throws BusinessException
	 */
	int addMemberCard(String json) throws BusinessException;

	/**
	 * 更新会员积分
	 * 
	 * @param json
	 * @return
	 * @throws BusinessException
	 */
	int updateMemberCard(String json) throws BusinessException;

	MemberCard getMemberCard(String memberId);

}
