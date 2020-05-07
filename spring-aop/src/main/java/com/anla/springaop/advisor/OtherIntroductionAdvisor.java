package com.anla.springaop.advisor;

import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.stereotype.Component;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/7 11:57
 **/
@Component
public class OtherIntroductionAdvisor extends DefaultIntroductionAdvisor {

    public OtherIntroductionAdvisor() {
        super(new OtherIntroductionInterceptor());
    }

    /**
     * createBean的时候判断bean是否需要被代理
     * @param clazz
     * @return
     */
    @Override
    public boolean matches(Class<?> clazz) {
        //只代理some对象
        boolean result =  clazz.isAssignableFrom(SomeService.class);
        return result;
    }
}
