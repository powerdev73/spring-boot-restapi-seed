package com.workershigh.web.controller.base;

import com.workershigh.web.enums.ResultCode;
import com.workershigh.web.response.ResponseResult;

public class BaseController {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResponseResult successResult() {
        return new ResponseResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage("SUCCESS");
    }

    public static <T> ResponseResult<T> successResult(T data) {
        return new ResponseResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage("SUCCESS")
                .setData(data);
    }

    public static ResponseResult ErrorResult(String message) {
        return new ResponseResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
