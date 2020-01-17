package com.mall.parking.base.gateway.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class JWTData {
	
	
	public String tokenKey;
	
	private String[] skipUrls;
}
