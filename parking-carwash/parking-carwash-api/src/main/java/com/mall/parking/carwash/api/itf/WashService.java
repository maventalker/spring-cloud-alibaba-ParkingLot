package com.mall.parking.carwash.api.itf;

import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public interface WashService {

	int wash(String json) throws BusinessException;
}
