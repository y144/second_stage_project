package com.bjpowernode.s04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 杨廷甲
 * 2020-12-10
 */

@Aspect
public class MyAspect {


    @After(value = "execution(* com.bjpowernode.s04.SomeServiceImpl.doFour(..))")
    public void myAspect(){
        System.out.println("我是最终通知；；；");

    }
}
