package com.mall.parking.charging.service;

import java.util.List;

import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public interface ChargingRuleService {

	List<ChargingRule> list() throws BusinessException;
}
