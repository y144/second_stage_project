package com.bjpowernode.proxy05;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class LogAop implements AOP {
    @Override
    public void before() {
        System.out.println("事务在最前端开启....");
    }

    @Override
    public void after() {

    }

    @Override
    public void exception() {

    }
}
