package com.anla.springbean.componet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

/**
 * @author anLA7856
 * @date 20-3-1 下午6:18
 * @description
 */
@Component
public class DemoTestAutowired {

    @Autowired
    private DateFormat dateFormat;


}
