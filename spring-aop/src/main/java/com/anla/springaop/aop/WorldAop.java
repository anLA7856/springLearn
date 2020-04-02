package com.anla.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 11:16
 **/
@Component
@Aspect
@Order(1)
public class WorldAop implements Ordered {

    /**
     * 后面是指service下面所有方法，注意有2个星。
     */
    @Pointcut("execution(* com.anla.springaop.service.*.*(..))")
    private void returnPointcut() {
    }

    @Before("returnPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        String apiName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        System.out.println("========== 调用方法WorldAop:{} start ==========, " + apiName);

        for (Object arg : joinPoint.getArgs()) {
            System.out.println("arg:," + arg);
        }
        System.out.println("========== 调用方法WorldAop:{} end ==========, " + apiName);
    }

    /**
     * 拦截器具体实现
     *
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("returnPointcut()")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("pjp is :" + pjp);
        return pjp.proceed();
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
