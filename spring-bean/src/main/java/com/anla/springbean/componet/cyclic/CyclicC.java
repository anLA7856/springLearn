package com.anla.springbean.componet.cyclic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author anLA7856
 * @date 20-3-4 下午11:06
 * @description
 */
@Component
public class CyclicC {
    private CyclicD cyclicD;
    @Autowired
    public CyclicC( CyclicD cyclicD) {
        this.cyclicD = cyclicD;
    }
}
