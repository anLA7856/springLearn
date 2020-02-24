package com.anla.springbean.componet.sub;

import org.springframework.stereotype.Component;

/**
 * 需要加上 @Component 说明是一个component，否则就算有扫描，也扫描不上
 * @author luoan
 * @version 1.0
 * @date 2020/2/24 13:28
 **/
@Component
public class Bird {

    public void hello(){
        System.out.println("hello I am a dog");
    }
}
