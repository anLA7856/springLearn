package com.anla.springbean.componet.mybatis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author anLA7856
 * @date 20-3-15 下午3:48
 * @description
 */
@Data
public class User implements Serializable {
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