package com.bjpowernode.s01;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        System.out.println(name +"  " + age +"执行了doSome()方法..........");
    }
}
