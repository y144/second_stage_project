package com.bjpowernode.proxy04;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class TransAop implements AOP {
    @Override
    public void before() {
        System.out.println("事务开启.........");
    }

    @Override
    public void after() {
        System.out.println("事务提交........");
    }

    @Override
    public void exception() {
        System.out.println("事务回滚.........");
    }
}
