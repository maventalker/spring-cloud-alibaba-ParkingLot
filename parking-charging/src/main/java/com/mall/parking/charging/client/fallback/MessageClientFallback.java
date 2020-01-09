package com.mall.parking.charging.client.fallback;

import org.springframework.stereotype.Component;

import com.mall.parking.charging.client.MessageClient;
import com.mall.parking.common.bean.CommonResult;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageClientFallback implements MessageClient {

	@Override
	public CommonResult<Integer> sendNotice(String json) throws BusinessException {
		CommonResult<Integer> commonResult = new CommonResult<>("invoke message service failed...");
		commonResult.setRespData(-1);
		log.warn("invoke message service failed.return fallback.");
		return commonResult;
	}

}
