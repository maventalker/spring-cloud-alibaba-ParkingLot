/**
 * 
 */
package com.mall.parking.charging.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.charging.client.fallback.BillServiceFallback;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@FeignClient(name = "finance-service",fallback = BillServiceFallback.class)
public interface BillFeignClient {

	@PostMapping("/billing/create")
	CommonResult<Integer> create(@RequestParam("json") String json) throws BusinessException;
}
