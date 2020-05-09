package com.anla.springaop.intercept;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/8 10:05
 **/
public class AdviseMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = null;
        try {
            System.out.println("方法执行之前：" + methodInvocation.getMethod().toString());
            result = methodInvocation.proceed();
            System.out.println("方法执行之后：" + methodInvocation.getMethod().toString());
            System.out.println("方法正常运行结果：" + result);
            return result;
        } catch (Exception e) {
            System.out.println("方法出现异常:" + e.toString());
            System.out.println("方法运行Exception结果：" + result);
            return result;
        }
    }
}
