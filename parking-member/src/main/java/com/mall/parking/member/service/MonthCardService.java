package com.mall.parking.member.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface MonthCardService {

	int addMonthCard(String json) throws BusinessException;

	boolean isMonthCardUser(String vehicleNo) throws BusinessException;

}
