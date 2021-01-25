package com.bjpowernode.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 杨廷甲
 * 2020-12-08
 */

//在spring的AOP中有相应的
public class LogAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("\n[系统日志]"+sf.format(new Date())+"----"+method.getName()+Arrays.toString(objects));
    }
}
