package com.mall.parking.charging.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.charging.client.BillFeignClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Component
@Slf4j
public class BillServiceFallback implements BillFeignClient {

	@Override
	public CommonResult<Integer> create(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>("finance service invoke fail");
		commonResult.setRespData(-1);
		log.warn("invoke finance service failback...");
		return commonResult;
	}

}
