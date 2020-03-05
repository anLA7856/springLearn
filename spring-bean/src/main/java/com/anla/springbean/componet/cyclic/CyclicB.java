package com.anla.springbean.componet.cyclic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author anLA7856
 * @date 20-3-4 下午11:05
 * @description
 */
@Component
public class CyclicB {
    @Autowired
    private CyclicA cyclicA;
}
