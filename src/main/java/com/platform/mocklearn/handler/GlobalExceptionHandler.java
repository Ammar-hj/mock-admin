package com.platform.mocklearn.handler;

import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.response.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        logger.error("Default Exception: " + e);
        return ApiRestResponse.error(RespCodeEnum.UNKNOWN_ERROR);
    }

    @ExceptionHandler(MockException.class)
    @ResponseBody
    public Object handleMallException(MockException e) {
        logger.error("MallException: " + e);
        return ApiRestResponse.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgumentNotNullException(MethodArgumentNotValidException e) {
        logger.error("MethodArgumentNotValidException: " + e);
        return handleBindingResult(e.getBindingResult());
    }

    private ApiRestResponse handleBindingResult(BindingResult result) {
        List<String> list = null;
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError err : allErrors) {
                String msg = err.getDefaultMessage();
                list.add(msg);
            }
        }
        if (list == null) {
            return ApiRestResponse.error(RespCodeEnum.ARGUMENTS_ERROR);
        }
        return ApiRestResponse.error(RespCodeEnum.ARGUMENTS_ERROR.getCode(), list.toString());
    }

}
