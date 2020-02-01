package com.mall.parking.card.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface MemberCardService {

	int addMemberCard(String json) throws BusinessException;

	int updateMemberCard(String json) throws BusinessException;

}
