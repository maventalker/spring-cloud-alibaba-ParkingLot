package com.mall.parking.charging.service;

import java.util.List;

import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface ChargingRuleService {

	List<ChargingRule> list() throws BusinessException;

	int refresh();
}
