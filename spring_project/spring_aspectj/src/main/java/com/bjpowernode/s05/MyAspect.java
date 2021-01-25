package com.bjpowernode.s05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 杨廷甲
 * 2020-12-10
 */

@Aspect
public class MyAspect {


    @After(value = "mypoint()")
    public void myAfter(){
        //切面的功能
        System.out.println("我是最终通知.........");
    }

    @Before(value = "mypoint()")
    public void myBefore(){
        //切面的功能
        System.out.println("我是前置通知.........");
    }


    @Pointcut(value = "execution(* com.bjpowernode.s05.*.*(..))")
    private void mypoint(){

    }
}
