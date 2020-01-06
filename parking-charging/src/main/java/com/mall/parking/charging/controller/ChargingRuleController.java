package com.mall.parking.charging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.charging.entity.ChargingRule;
import com.mall.parking.charging.service.ChargingRuleService;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@RequestMapping("chargingRule")
@RestController
public class ChargingRuleController {

	@Autowired
	ChargingRuleService chargingRuleService;
	
	@PostMapping("/list")
	public List<ChargingRule> list() throws BusinessException{
		return chargingRuleService.list();
	}
	
	/**
	 * when charging rule changed,use this method to refresh data to cache
	 * 
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/fresh")
	public CommonResult<Integer> refresh() throws BusinessException{
		CommonResult<Integer> result = new CommonResult<>();
		int rtn = chargingRuleService.refresh();
		result.setRespData(rtn);
		return result;
	}
}
