package com.anla.springtransactionaspectJ.model;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private String email;

    private String password;

    private Integer actived;

    private String activateCode;

    private String joinTime;

    private String username;

    private String description;

    private String headUrl;

    private String position;

    private String school;

    private String job;

    private Integer likeCount;

    private Integer postCount;

    private Integer scanCount;

    private Integer followCount;

    private Integer followerCount;


}