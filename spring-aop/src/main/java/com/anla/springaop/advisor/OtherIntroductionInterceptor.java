package com.anla.springaop.advisor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.IntroductionInterceptor;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/7 11:58
 **/
public class OtherIntroductionInterceptor implements IntroductionInterceptor, IntroductionInfo, IOther {
    /**
     * 扩展功能的实现
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //当前方法的声明类是否实现了需要拓展功能的接口
        if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
            //调用this的此方法
            return invocation.getMethod().invoke(this, invocation.getArguments());
        }
        return invocation.proceed();
    }

    @Override
    public boolean implementsInterface(Class<?> ifc) {
        Class<?>[] interfaces = this.getInterfaces();
        for (Class clazz : interfaces) {
            if (ifc.isInterface() && ifc.isAssignableFrom(clazz)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Class<?>[] getInterfaces() {
        return new Class[] {IOther.class};
    }

    @Override
    public void doOther() {
        System.out.println("doOther...");
    }
}
