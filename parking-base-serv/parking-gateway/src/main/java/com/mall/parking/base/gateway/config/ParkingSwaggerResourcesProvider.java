package com.mall.parking.base.gateway.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
public class ParkingSwaggerResourcesProvider implements SwaggerResourcesProvider {

	/**
	 * swagger2的特定资源地址
	 */
	private static final String SWAGGER2URL = "/v2/api-docs";

	/**
	 * 网关路由器
	 */
	private final RouteLocator routeLocator;

	/**
	 * 本应用名称，下文需要将自己排除掉
	 */
	@Value("${spring.application.name}")
	private String curApplicationName;

	public ParkingSwaggerResourcesProvider(RouteLocator routeLocator) {
		this.routeLocator = routeLocator;
	}

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		List<String> routeHosts = new ArrayList<>();
		// 从网关配置中拿到所有应用的serviceId
		routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
				.filter(route -> !curApplicationName.equals(route.getUri().getHost()))
				.subscribe(route -> routeHosts.add(route.getUri().getHost()));

		Set<String> allUrls = new HashSet<>();
		routeHosts.forEach(instance -> {
			// /serviceId/v2/api-info，当网关调用这个接口时，会自动寻找对应的服务实例
			String url = "/" + instance + SWAGGER2URL;
			if (!allUrls.contains(url)) {
				allUrls.add(url);
				SwaggerResource swaggerResource = new SwaggerResource();
				swaggerResource.setUrl(url);
				//swaggerResource.setLocation(url);location已过期，直接采用url代替
				swaggerResource.setName(instance);
				resources.add(swaggerResource);
			}
		});
		return resources;
	}

}
