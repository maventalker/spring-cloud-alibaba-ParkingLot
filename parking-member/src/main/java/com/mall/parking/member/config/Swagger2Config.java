package com.mall.parking.member.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author https://backkoms.github.io/
 *
 */
@EnableSwagger2
@Configuration
@Profile({ "dev", "test" })
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        parameterBuilder.modelRef(new ModelRef("String")).name("token").parameterType("header").description("token").defaultValue("").
        //考虑到有些请求是不需要token的，此处不能必填
        required(false).build();
        parameters.add(parameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().globalOperationParameters(parameters).securitySchemes(getSecuritySchemes());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Member会员模块接口层（基于SpringBoot2+Swagger2）.")
				.contact(new Contact("growithus", "https://backkoms.github.io/", "andy.deqiang@gmail.com"))
				.version("1.0")
				.description("").build();
	}


    private List<ApiKey> getSecuritySchemes() {
        List<ApiKey> keys = new ArrayList<>();
        ApiKey key  = new ApiKey("token", "token", "header");
        keys.add(key);
        return keys;
    }
}