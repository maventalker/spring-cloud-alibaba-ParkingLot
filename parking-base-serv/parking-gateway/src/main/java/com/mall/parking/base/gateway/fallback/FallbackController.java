package com.mall.parking.base.gateway.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.parking.common.bean.CommonResult;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("error")
@Slf4j
public class FallbackController {

	@RequestMapping("/fallback")
	public CommonResult<String> fallback() {
		CommonResult<String> errorResult = new CommonResult<>("Invoke failed.");
		log.error("Invoke service failed...");
		return errorResult;
	}
}
