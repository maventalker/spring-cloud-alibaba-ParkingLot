package com.mall.parking.charging.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.entity.ChargingRuleExample;
import com.mall.parking.charging.mapper.ChargingRuleMapper;
import com.mall.parking.charging.service.ChargingRuleService;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class ChargingRuleServiceImpl implements ChargingRuleService {

	@Autowired
	ChargingRuleMapper ruleMapper;

	@Override
	public List<ChargingRule> list() throws BusinessException {
		ChargingRuleExample example = new ChargingRuleExample();
		example.setOrderByClause("start asc");
		log.info("get charging rule suc!");
		return ruleMapper.selectByExample(example);
	}

}
