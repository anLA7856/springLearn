package com.anla.springwebmvc.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 1. Spring框架会在调用完Controller之后、渲染View之前检查Model的信息，
 * 并把@SessionAttributes()注释标明的属性加入session中（@SessionAttributes()注释标明的属性也就是在Model中存在的属性，
 * 如果Model中不存在该属性，session也不会注入成功。）
 *
 * 2. @ModelAttribute在声明Controller的参数的时候，可以用来表明此参数引用某个存在在Model中的对象，
 * 如果这个对象已经存在于Model中的话（Model可以在调用Controller之前就已经保存有数据，
 * 这应该不仅仅因为HandlerInterceptor或者@ModelAttribute标记的方法已经显式的将一些对象加入到了Model对象中，
 * 也因为Spring会默认将一些对象加入到Model中，这一点很重要）。
 *
 * 3. 如果Session中已经存在某个对象，那么可以直接使用ModelAttribute声明Controller的参数，在Controller中可以直接使用它。
 *
 * 4. @SessionAttributes只能使用在类定义上。
 * @author luoan
 * @version 1.0
 * @date 2020/5/27 13:37
 **/
@Controller
@SessionAttributes("user")
public class SessionAttributesController {

    @RequestMapping("/sessionAttributes/{useId}")
    @ResponseBody
    public String toIndex(@PathVariable String useId, Model model) {
        model.addAttribute("user", "我是user"+useId);
        //将user添加到Model当中，用该函数添加的属性，默认进入视图的requestScope作用域中，因为@SessionAttributes注解的缘故，此时视图的sessionScope作用域也存在user对象。
        return "showUser";
    }
}
