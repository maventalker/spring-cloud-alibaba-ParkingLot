package com.mall.parking.common.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: ResultEntity <br/>
 * Function:<br/>
 * date: 2018年12月5日 下午3:15:31 <br/>
 *
 * @author apple
 * @version @param <T>
 * @since JDK 1.6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResultEntity<T> {

    private int respCode = 1;

    private String respMsg = "成功！";

    @SuppressWarnings("unchecked")
    private T respData = (T) new Object();

    private Map<String, Object> respMap = new HashMap<String, Object>();

    private String signature;
    private String deviceType;
    private String dataCode;

    @SuppressWarnings("rawtypes")
    public static <T> ErrorResultEntity fail(String message) {
        return new ErrorResultEntity<T>(0, message, null, null, null, null, null);
    }
    
    @SuppressWarnings("rawtypes")
    public static <T> ErrorResultEntity error(String message) {
        return new ErrorResultEntity<T>(-1, message, null, null, null, null, null);
    }

    @SuppressWarnings("rawtypes")
    public static <T> ErrorResultEntity success(T data, Map<String, Object> result) {
        return new ErrorResultEntity<T>(0, "成功", data, result, null, null, null);
    }
}
