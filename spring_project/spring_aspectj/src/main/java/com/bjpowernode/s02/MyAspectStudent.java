package com.bjpowernode.s02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 杨廷甲
 * 2020-12-10
 */

@Aspect //表示次类是切面类
public class MyAspectStudent {

    @AfterReturning(value = "execution(* com.bjpowernode.s02.*.*(..))",returning = "res")
    public void myAfter1(Object res){

        Student stu = null;

        if (res != null){
            stu = ((Student)res);
            stu.setAge(123);
        }

        System.out.println("我是后置通知，增强的功能......"+stu.getAge());
    }
}
