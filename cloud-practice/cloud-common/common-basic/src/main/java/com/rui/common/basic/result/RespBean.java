package com.rui.common.basic.result;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * description:
 * date: 2022/6/15 14:44
 *
 * @author rui
 */
@Data
public class RespBean<T> implements Serializable {
    private String code;

    private T data;

    private String msg;

    public static <T> RespBean<T> success() {
        return success(null, null);
    }

    public static <T> RespBean<T> success(String msg) {
        return success(null, msg);
    }

    public static <T> RespBean<T> success(T data, String msg) {
        RespBean<T> result = new RespBean<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ObjectUtil.isNull(msg) ? ResultCode.SUCCESS.getMsg() : msg);
        result.setData(data);
        return result;
    }

    public static <T> RespBean<T> failed() {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), ResultCode.SYSTEM_EXECUTION_ERROR.getMsg(), null);
    }

    public static <T> RespBean<T> failed(String msg) {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> RespBean<T> judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> RespBean<T> failed(ResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }

    public static <T> RespBean<T> failed(ResultCode resultCode, String msg) {
        return result(resultCode.getCode(), msg, null);
    }

    private static <T> RespBean<T> result(ResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> RespBean<T> result(String code, String msg, T data) {
        RespBean<T> result = new RespBean<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static boolean isSuccess(RespBean<?> result) {
        return result != null && ResultCode.SUCCESS.getCode().equals(result.getCode());
    }
}
