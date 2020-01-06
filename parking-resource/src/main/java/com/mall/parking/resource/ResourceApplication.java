package com.mall.parking.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@MapperScan("com.mall.parking.resource.mapper")
public class ResourceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
		log.info("resource application is running now ...");
	}
}
