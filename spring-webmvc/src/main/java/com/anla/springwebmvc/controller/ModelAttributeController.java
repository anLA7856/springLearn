package com.anla.springwebmvc.controller;

import com.anla.springwebmvc.model.Hello;
import com.anla.springwebmvc.service.ApplicationScopeService;
import com.anla.springwebmvc.service.RequestScopeService;
import com.anla.springwebmvc.service.SessionScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:48
 **/
@Controller
@RefreshScope
public class ModelAttributeController {

    /**
     * 使用该方法，可以给该controller里面，每个方法，都会加上一个name的model属性
     * @param name
     * @param model
     */
    @ModelAttribute
    public void populateModel(@RequestParam String name, Model model){
        model.addAttribute("name", name);
    }

    /**
     * 这种写法，就会有一个名字为hello的Model参数
     * 这样一来，就必须传2个参数
     * @param name
     * @param age
     * @return
     */
    @ModelAttribute
    public Hello defaultModelAttribute(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return new Hello(name, age);
    }

    /**
     * 直接指定输出
     * @return
     */
    @ModelAttribute("name2")
    public String helloWorld(){
        return "name2";
    }


    @GetMapping("/modelAttribute")
    public String index() {
        return "modelAttribute";
    }



}
