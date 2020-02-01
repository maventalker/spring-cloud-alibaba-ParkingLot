package com.mall.parking.carwash.serv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.mall.parking.carwash.serv.mapper")
@EnableDiscoveryClient
public class CarWashApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWashApplication.class, args);
		log.info("CarWash application is running...");
	}

}
