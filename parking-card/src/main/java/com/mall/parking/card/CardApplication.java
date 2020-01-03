package com.mall.parking.card;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@MapperScan("com.mall.parking.card.mapper")
@EnableDiscoveryClient
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
		log.info("CardApplication is running now...");
	}

}
