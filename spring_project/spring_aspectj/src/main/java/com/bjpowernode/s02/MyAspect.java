package com.bjpowernode.s02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 杨廷甲
 * 2020-12-10
 */

@Aspect
public class MyAspect {

    @AfterReturning(value = "execution(* com.bjpowernode.s02.SomeServiceImpl.doFirst(..))",returning = "res")
    public void MyAfter(Object res){
        String returnRes = null;
        //对返回值进行变更处理，观察在外部调用时，有没有变化
        if (res != null){
            returnRes = ((String)res).toUpperCase();
        }

        System.out.println("我是后置通知是增强了的功能......"+returnRes);
    }

}
