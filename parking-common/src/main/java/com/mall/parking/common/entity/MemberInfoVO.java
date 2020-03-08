package com.mall.parking.common.entity;

import lombok.Data;

@Data
public class MemberInfoVO {

	private String id;

	/**
	 * 手机
	 */
	private String phone;

	/**
	 * 生日
	 */
	private String birth;

	/**
	 * 姓名
	 */
	private String fullName;

	/**
	 * 当前可用积分
	 */
	private String curQty;
	
	/**
	 * 车牌号
	 */
	private String plateNo;

}
