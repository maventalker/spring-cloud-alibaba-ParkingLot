package com.mall.parking.common.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * @author apple
 *
 */
@Data
public class CommonResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int respCode = 1;

	private String respMsg = "请求执行成功！";

	@SuppressWarnings("unchecked")
	private T respData = (T)new Object();

	private Map<String, String> respMap = new HashMap<String, String>();

	@SuppressWarnings("unchecked")
	public CommonResult(String errorMsg) {
		this.respMsg = errorMsg;
		this.respCode = ParkingConstant.Code.error;
		this.respData = (T)new Object();
		this.respMap = new HashMap<String, String>();
	}

	@SuppressWarnings("unchecked")
	public CommonResult() {
		this.respData = (T)new Object();
		this.respMap = new HashMap<String, String>();
	}

	@SuppressWarnings("unchecked")
	public void success(Object object) {
		this.respCode = ParkingConstant.Code.success;
		this.respMsg = ParkingConstant.Message.success;
		this.respData = (T)object;
		this.respMap = new HashMap<String, String>();
	}

	@SuppressWarnings("unchecked")
	public void error() {
		this.respCode = ParkingConstant.Code.error;
		this.respMsg = ParkingConstant.Message.error;
		this.respData = (T)new Object();
		this.respMap = new HashMap<String, String>();
	}

	@SuppressWarnings("unchecked")
	public void error(String message) {
		this.respCode = ParkingConstant.Code.error;
		this.respMsg = message;
		this.respData = (T)new Object();
		this.respMap = new HashMap<String, String>();
	}
}
