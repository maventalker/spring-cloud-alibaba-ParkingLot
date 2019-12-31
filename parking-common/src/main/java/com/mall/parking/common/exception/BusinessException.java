package com.mall.parking.common.exception;

import org.apache.poi.ss.formula.functions.T;

import com.mall.parking.common.bean.CommonResult;

public class BusinessException extends BaseException {


	private static final long serialVersionUID = 1L;
	
    public BusinessException() {
        super();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public BusinessException(int errorCode, String errorMsg, CommonResult<T> dataResult) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.dataResult = dataResult;
    }

    public BusinessException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public BusinessException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
    }

    public BusinessException(int errorCode, String errorMsg, CommonResult<T> dataResult, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.dataResult = dataResult;
    }

}
