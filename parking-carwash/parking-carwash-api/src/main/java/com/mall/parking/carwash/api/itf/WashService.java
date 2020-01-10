package com.mall.parking.carwash.api.itf;

import com.mall.parking.common.exception.BusinessException;

public interface WashService {

	int wash(String json) throws BusinessException;
}
