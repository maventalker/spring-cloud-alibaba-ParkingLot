package com.mall.parking.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@MapperScan("com.mall.parking.message.mapper")
@EnableBinding({Sink.class})
public class MessageApplication {

	public static void main(String[] args) {

		SpringApplication.run(MessageApplication.class, args);
		log.info("message application is running now...");
	}

}
