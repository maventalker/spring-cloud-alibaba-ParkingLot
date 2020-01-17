package com.mall.parking.base.gateway.filter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.parking.base.gateway.jwt.JWTUtils;
import com.mall.parking.common.bean.CommonResult;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JWTFilter implements GlobalFilter, Ordered {

	@Autowired
	JWTData jwtData;

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String url = exchange.getRequest().getURI().getPath();

		// 跳过不需要验证的路径
		if (null != jwtData.getSkipUrls() && Arrays.asList(jwtData.getSkipUrls()).contains(url)) {
			return chain.filter(exchange);
		}

		// 获取token
		String token = exchange.getRequest().getHeaders().getFirst("token");
		ServerHttpResponse resp = exchange.getResponse();
		if (StringUtils.isBlank(token)) {
			// 没有token
			return authError(resp, "请先登陆!");
		} else {
			// 有token
			try {
				JWTUtils.parseJWT(token, jwtData.getTokenKey());
				log.info("验证通过");
				return chain.filter(exchange);
			} catch (ExpiredJwtException e) {
				log.error(e.getMessage(), e);
				return authError(resp, "token过期");
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				return authError(resp, "认证失败");
			}
		}
	}

	/**
	 * 认证错误输出
	 * 
	 * @param resp    响应对象
	 * @param message 错误信息
	 * @return
	 */
	private Mono<Void> authError(ServerHttpResponse resp, String message) {
		resp.setStatusCode(HttpStatus.UNAUTHORIZED);
		resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
		CommonResult<String> returnData = new CommonResult<>(org.apache.http.HttpStatus.SC_UNAUTHORIZED + "");
		returnData.setRespMsg(message);
		String returnStr = "";
		try {
			returnStr = objectMapper.writeValueAsString(returnData.getRespMsg());
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
		return resp.writeWith(Flux.just(buffer));
	}

	@Override
	public int getOrder() {
		return -200;
	}

}
