package com.mall.parking.charging.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface ExistsService {
	
	int createExsits(String json) throws BusinessException;

}
