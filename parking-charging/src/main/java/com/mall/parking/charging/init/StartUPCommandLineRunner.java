package com.mall.parking.charging.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class StartUPCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("other way to init the data after application running ...");
	}

}
