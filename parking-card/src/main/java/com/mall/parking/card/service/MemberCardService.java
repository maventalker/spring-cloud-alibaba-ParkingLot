package com.mall.parking.card.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public interface MemberCardService {

	int addMemberCard(String json) throws BusinessException;

}
