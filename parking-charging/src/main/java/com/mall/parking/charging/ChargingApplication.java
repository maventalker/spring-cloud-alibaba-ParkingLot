package com.mall.parking.charging;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@SpringBootApplication
@MapperScan("com.mall.parking.charging.mapper")
@EnableFeignClients(basePackages="com.mall.parking.charging.client")
@Slf4j
@EnableDiscoveryClient
@EnableHystrix
public class ChargingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargingApplication.class, args);
		log.info("charging application is running now !");
	}

}
