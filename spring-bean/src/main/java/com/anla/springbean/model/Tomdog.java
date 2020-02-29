package com.anla.springbean.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 里面有个变量，需要dog作为传参
 * @author luoan
 * @version 1.0
 * @date 2020/2/24 13:22
 **/
public class Tomdog {

    private Dog dog;

    public Tomdog(@Autowired Dog dog) {
        this.dog = dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String dogwangwang(){
        return dog.afterWangwang();
    }
}
