package com.anla.springwebmvc.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:48
 **/
@Controller
@RefreshScope
public class IndexController implements EnvironmentAware {

    @Autowired
    private RequestScopeService requestScopeService;
    @Autowired
    private SessionScopeService sessionScopeService;
    @Autowired
    private ApplicationScopeService applicationScopeService;

    private Environment environment;

    @GetMapping("index")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        requestScopeService.helloScope();
        sessionScopeService.helloScope();
        applicationScopeService.helloScope();
        return "index";
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
