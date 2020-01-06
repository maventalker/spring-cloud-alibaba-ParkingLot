package com.mall.parking.charging.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

@Component
public interface StallParkedFeignClient {

	@PostMapping("/stall/occupy")
	CommonResult<Integer> occupy(@RequestParam("json") String json) throws BusinessException;
}
