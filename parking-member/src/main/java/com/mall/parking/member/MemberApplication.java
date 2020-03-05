package com.mall.parking.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@SpringBootApplication
@MapperScan("com.mall.parking.member.mapper")
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.mall.parking.member.client")
public class MemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
		log.info("MemberApplication is running now...");
	}

	
	@Bean
    public IRule ribbonRule() {
        // 负载均衡规则，改为随机
        return new RandomRule();
//        return new BestAvailableRule();
//        return new WeightedResponseTimeRule();
//        return new RoundRobinRule();
//        return new RetryRule();
    }
}
