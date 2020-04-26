package com.anla.springaop.service;

import org.springframework.stereotype.Service;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 10:54
 **/

@Service
public class WorldService implements WorldAPI{
    public String world(String message){
        return "WorldService say  : "+message;
    }
}
