package com.mall.parking.card.service;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface MemberSignService {

	int sign(String json) throws BusinessException;

}
