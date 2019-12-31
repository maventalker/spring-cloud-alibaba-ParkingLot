package com.mall.parking.common.exception;


import org.apache.poi.ss.formula.functions.T;

import com.mall.parking.common.bean.CommonResult;

/**
 * 异常处理基础类
 * @author zj
 *
 */
public abstract class BaseException extends Exception {

    private static final long serialVersionUID = 1L;

    protected int errorCode;

    protected CommonResult<T> dataResult;

    protected BaseException() {
        super();
    }

    protected BaseException(String errorMsg) {
        super(errorMsg);
    }

    protected BaseException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }

    protected BaseException(int errorCode, String errorMsg, CommonResult<T> dataResult) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.dataResult = dataResult;
    }

    protected BaseException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    protected BaseException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
    }

    protected BaseException(int errorCode, String errorMsg, CommonResult<T> dataResult, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.dataResult = dataResult;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public CommonResult<T> getDataResult() {
        return dataResult;
    }

    public void setDataResult(CommonResult<T> dataResult) {
        this.dataResult = dataResult;
    }
}
