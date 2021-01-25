package com.bjpowernode.proxy05;

/**
 * 杨廷甲
 * 2020-12-08
 */

//不管你的日志处理还得事务的处理，我都给你规定同一种规范，你在实现日志和事务功能的时候，都实现这个接口，按照我的流程走，需要什么方法就在在那个方法中写相应的功能，然后在调用，
public interface AOP {


    void before();

    void after();

    void exception();
}
