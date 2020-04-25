package com.anla.springaop.declareparents;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 不可运行
 * @author luoan
 * @version 1.0
 * @date 2020/4/25 16:19
 **/
@Aspect
public class RoleAspect {

    /**
     * 这个切面，多实现了一个接口RoleVerifier，如此一来，可以强转。
     * 提供了一个默认实现类，所以可以墙砖后，调用verify方法。
     */
    @DeclareParents(value="com.anla.springaop.declareparents+", defaultImpl=RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;


    @Pointcut("execution(* com.anla.springaop.declareparents.*(..))")
    public void print(){

    }

    @Before("print()")
    public void before(){
        System.out.println("before....");
    }

    @After("print()")
    public void after(){
        System.out.println("after....");
    }

    @AfterReturning("print()")
    public void afterReturning(){
        System.out.println("afterReturning....");
    }

    @AfterThrowing("print()")
    public void afterThrowing(){
        System.out.println("afterThrowing....");
    }

    @Around("print()")
    public void around(ProceedingJoinPoint jp){
        System.out.println("around before ...");
        try{
            jp.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
        System.out.println("around after ...");
    }
}
