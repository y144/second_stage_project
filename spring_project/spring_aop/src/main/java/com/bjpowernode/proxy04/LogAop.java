package com.bjpowernode.proxy04;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class LogAop implements AOP {
    @Override
    public void before() {
        System.out.println("日志在最前端开启....");
    }

    @Override
    public void after() {

    }

    @Override
    public void exception() {

    }
}
