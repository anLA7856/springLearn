package com.anla.springwebmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 16:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hello {
    private String name;

    private Integer age;
}
