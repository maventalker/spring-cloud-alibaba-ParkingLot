package com.mall.parking.charging.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface EntranceService {

	int createEntrance(String json) throws BusinessException;
}
