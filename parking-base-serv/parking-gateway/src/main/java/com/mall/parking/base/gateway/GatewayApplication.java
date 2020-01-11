package com.mall.parking.base.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.mall.parking.base.gateway.config.AddrKeyResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
		log.info("gateway service is running now ...");
	}
	
	
	@Bean
	public AddrKeyResolver addrKeyResolver() {
		return new AddrKeyResolver();
	}
}
