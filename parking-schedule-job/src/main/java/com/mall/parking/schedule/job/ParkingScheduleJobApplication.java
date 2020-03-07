package com.mall.parking.schedule.job;

import java.time.Duration;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication
@EnableFeignClients("com.mall.parking.schedule.job.client")
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
public class ParkingScheduleJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingScheduleJobApplication.class, args);
	}
	
	@Bean
	public LockProvider lockProvider(DataSource dataSource) {
	    return new JdbcTemplateLockProvider(dataSource);
	}
	
}
