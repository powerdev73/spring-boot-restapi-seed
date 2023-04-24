package com.powerdev.web.response;

import com.powerdev.web.enums.ResultCode;

public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public ResponseResult<T> setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
