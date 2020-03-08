package com.anla.springbean.componet.cyclic;

import org.springframework.stereotype.Component;

/**
 * @author anLA7856
 * @date 20-3-4 下午11:06
 * @description
 */
@Component
public class CyclicD {

    private CyclicC cyclicC;
//    @Autowired
    public CyclicD( CyclicC cyclicC) {
        this.cyclicC = cyclicC;
    }

    /**
     * 没有这个默认构造方法则会报错，因为造成了循环依赖。
     */
    public CyclicD() {
    }
}
