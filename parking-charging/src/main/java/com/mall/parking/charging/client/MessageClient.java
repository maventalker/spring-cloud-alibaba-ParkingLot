package com.mall.parking.charging.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mall.parking.charging.client.fallback.MessageClientFallback;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
@FeignClient(name = "message-service", fallback = MessageClientFallback.class)
public interface MessageClient {

	@PostMapping("/msg/sendNotice")
	CommonResult<Integer> sendNotice(@RequestParam("json") String json) throws BusinessException;
}
