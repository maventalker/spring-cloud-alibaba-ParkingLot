package com.mall.parking.charging.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.charging.client.BillFeignClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Component
public class BillServiceFallback implements BillFeignClient {

	@Override
	public CommonResult<Integer> create(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>("finance service invoke fail");
		return commonResult;
	}

}
