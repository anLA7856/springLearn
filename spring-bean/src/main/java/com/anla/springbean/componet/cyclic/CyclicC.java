package com.anla.springbean.componet.cyclic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author anLA7856
 * @date 20-3-4 下午11:06
 * @description
 */
public class CyclicC {
    private CyclicD cyclicD;
    public CyclicC(@Autowired CyclicD cyclicD) {
        this.cyclicD = cyclicD;
    }
}
