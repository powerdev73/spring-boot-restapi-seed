package com.workershigh.web.response;

import com.workershigh.web.enums.ResultCode;
import lombok.*;

public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public ResponseResult setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult setData(T data) {
        this.data = data;
        return this;
    }
}
