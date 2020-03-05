package com.mall.parking.base.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ParkingHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingHystrixDashboardApplication.class, args);
	}

}
