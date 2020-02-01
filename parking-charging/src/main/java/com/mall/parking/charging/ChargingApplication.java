package com.mall.parking.charging;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@SpringBootApplication
@MapperScan("com.mall.parking.charging.mapper")
@EnableFeignClients(basePackages="com.mall.parking.charging.client")
@Slf4j
@EnableDiscoveryClient
@EnableHystrix
@EnableBinding({Source.class})
public class ChargingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargingApplication.class, args);
		log.info("charging application is running now !");
	}

}
