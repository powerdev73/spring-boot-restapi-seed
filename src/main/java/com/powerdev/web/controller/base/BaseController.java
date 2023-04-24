package com.powerdev.web.controller.base;

import com.powerdev.web.enums.ResultCode;
import com.powerdev.web.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BaseController {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResponseResult successResult() {
        return new ResponseResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> ResponseResult<T> successResult(T data) {
        return new ResponseResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResponseResult ErrorResult(String message) {
        return new ResponseResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
