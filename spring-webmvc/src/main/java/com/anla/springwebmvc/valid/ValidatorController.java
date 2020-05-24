package com.anla.springwebmvc.valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * 只是作为 @Valid 和 @InitBinder例子，跑不起来。
 *
 *
 * @author luoan
 * @version 1.0
 * @date 2020/5/24 10:08
 **/
@Controller
@RequestMapping("/valid")
public class ValidatorController {
    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.addValidators(userValidator);
    }

    @RequestMapping(value = {"/index","/",""}, method = {RequestMethod.GET})
    public String index(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("user", new User());
        return "user.jsp";
    }

    @GetMapping("/signup")
    public String signUp(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("user",user);
        return "user.jsp";
    }
}
