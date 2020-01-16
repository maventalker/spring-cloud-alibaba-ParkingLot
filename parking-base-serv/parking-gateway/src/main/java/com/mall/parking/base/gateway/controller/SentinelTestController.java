package com.mall.parking.base.gateway.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("sentinel")
@Slf4j
public class SentinelTestController {

	@PostMapping("test")
	public String test() {
		String dString = UUID.randomUUID().toString();
		log.info(dString);
		return dString;
	}
}
