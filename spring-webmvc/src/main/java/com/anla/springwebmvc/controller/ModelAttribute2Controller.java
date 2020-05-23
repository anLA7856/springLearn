package com.anla.springwebmvc.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * 更多例子可以看：https://blog.csdn.net/leo3070/article/details/81046383
 *
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:48
 **/
@Controller
@RefreshScope
public class ModelAttribute2Controller {

    /**
     * 默认通过 getMapping 中定位到了 view 的名字 modelAttribute2
     * 用的是这个DefaultRequestToViewNameTranslator
     * 因为上面已经将后缀改为html了
     *
     * 此时modelAttribut为 <name, hello?>
     * @return
     */
    @GetMapping("/modelAttribute2")
    @ModelAttribute("name")
    public String index() {
        return "hello？";
    }



}
