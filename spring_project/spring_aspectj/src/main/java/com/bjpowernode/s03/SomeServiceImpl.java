package com.bjpowernode.s03;

import org.springframework.beans.factory.parsing.SourceExtractor;

import javax.xml.transform.Source;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        System.out.println(name +"  " + age +"执行了doSome()方法..........");
    }

    @Override
    public String doThree(String name, int age) {

        System.out.println("主业务doThree实现功能");
        return "doThree";
    }
}
