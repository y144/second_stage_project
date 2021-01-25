package com.bjpowernode.s05;

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

    @Override
    public String doFour(String name, int age) {
        System.out.println("执行了业务方法doFour()././././");
        return "flksdmfldskakkak";
    }
}
