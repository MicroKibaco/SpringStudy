package com.ai.springboot.handle;

import com.ai.springboot.controller.GirlController;
import com.ai.springboot.domain.Result;
import com.ai.springboot.exception.GirlException;
import com.ai.springboot.util.ResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("[系统异常]{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }

}
