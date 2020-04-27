package com.anla.springloadtimeweaver;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * 改类没有加@configuration，所以不会被扫描到spring 容器中
 * @author luoan
 * @version 1.0
 * @date 2020/4/27 11:33
 **/
@Aspect
public class UserAspect {

    @Pointcut("execution(public * com.anla.springloadtimeweaver.*.*(..))")
    public void pointCut(){

    }
    @Around("pointCut()")
    public void advise(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        System.out.println(signature+" start..... ");
        pjp.proceed();
        System.out.println(signature+" end......");
    }
}