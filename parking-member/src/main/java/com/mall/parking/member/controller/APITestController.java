package com.mall.parking.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("test")
@Api("测试类")
public class APITestController {

	@ApiOperation("问候")
	@PostMapping("/hello")
	@ApiImplicitParam(required = true, name = "name", dataType = "String", value = "名字", defaultValue = "world", paramType = "query")
	public Hello hello(String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}

}

@ApiModel
class Hello {

	@ApiModelProperty("姓名")
	private String name;
	
	@ApiModelProperty("年龄")
	private int age = 10;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
