package com.anla.springwebmvc.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 全局异常处理
 * 2. 全局数据绑定
 * 3. 全局数据预处理
 *
 * 灵活使用这三个功能，可以帮助我们简化很多工作
 *
 *
 * @RestControllerAdvice 和 ControllerAdvice 用法一致。
 * @author luoan
 * @version 1.0
 * @date 2020/5/24 10:29
 **/
@ControllerAdvice
public class MyGlobalExceptionHandler {

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView customException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("myerror");
        return mv;
    }


    /**
     * 全局数据绑定
     * 即请求前会被塞入
     * @return
     */
    @ModelAttribute(name = "md")
    public Map<String,Object> mydata() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }


    // 全局数据预处理不作处理

}
