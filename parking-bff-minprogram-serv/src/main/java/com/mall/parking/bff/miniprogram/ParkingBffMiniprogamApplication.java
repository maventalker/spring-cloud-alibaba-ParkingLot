package com.mall.parking.bff.miniprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ParkingBffMiniprogamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingBffMiniprogamApplication.class, args);
	}

}
