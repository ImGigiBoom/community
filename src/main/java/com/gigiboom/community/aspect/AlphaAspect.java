package com.gigiboom.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AlphaAspect {

    // execution(任意返回值 com.gigiboom.community.service.所有的类.所有的方法(所有的参数))
    @Pointcut("execution(* com.gigiboom.community.service.*.*(..))")
    public void pointcut() {}

    // 前置通知
    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    // 后置通知
    @After("pointcut()")
    public void After() {
        System.out.println("before");
    }

    // 返回通知 返回通知与后置通知类似，区别在于，返回通知需要在程序正确执行后才会执行，若程序发生异常，则返回通知不会执行
    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    // 异常通知 只有当程序发生异常时才会执行，异常通知能够获取到方法发生了什么异常
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    // 环绕通知的功能比较强大，它能够通过一个方法实现之前的所有通知效果
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前置通知
        System.out.println("aroundBefore");
        // 执行目标方法
        Object obj = joinPoint.proceed();
        // 后置通知
        System.out.println("aroundAfter");
        return obj;
    }
}
