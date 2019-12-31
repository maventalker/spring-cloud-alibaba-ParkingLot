package com.mall.parking.member.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public interface MonthCardService {

	int addMonthCard(String json) throws BusinessException;

	boolean isMonthCardUser(String vehicleNo) throws BusinessException;

}
