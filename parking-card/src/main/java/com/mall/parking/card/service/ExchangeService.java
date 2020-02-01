package com.mall.parking.card.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface ExchangeService {

	int createExchange(String json) throws BusinessException;

}
