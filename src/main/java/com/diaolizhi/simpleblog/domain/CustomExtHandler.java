package com.diaolizhi.simpleblog.domain;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/19 14:20
 */
@ControllerAdvice
public class CustomExtHandler {

    /**
     * 捕获异常，返回自定义 404 页面
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String extHandler(Exception e) {
        e.printStackTrace();
        return "/error2";
    }
}
