package com.springboot.bikini.exp;

import com.springboot.bikini.model.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @ExceptionHandler
    @ResponseBody
    JSONResult handleException(Exception e){
        logger.error(e.getMessage());
        e.printStackTrace();
        return new JSONResult(501,"未知错误，操作失败",e);
    }
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    JSONResult handleBusinessException(BusinessException e){
        logger.error(e.getMessage());
        return new JSONResult(501,"未知错误，操作失败",e);
    }
}
