package com.mall.parking.common.bean;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public class ParkingConstant {

	public static final class Code {
		public static final String SUCCESS = "1";

		public static final String FAIL = "0";
		/**
		 * @Fields ok : 成功
		 */
		public static final int success = 1;
		/**
		 * @Fields error : 失败
		 */
		public static final int error = 0;

		/**
		 * empty:无数据
		 * 
		 * @since JDK 1.6
		 */
		public static final int empty = -1;
	}

	public static final class Message {
		/**
		 * @Fields ok : 成功
		 */
		public static final String success = "成功!";
		/**
		 * @Fields error : 失败
		 */
		public static final String error = "系统错误!";
		public static final String object_not_find = "找不到要操作的记录!";
	}

	public static final class cache {
		
		public static final String chargingRule = "ruleKey";
	}

}
