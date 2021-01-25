package com.bjpowernode.s02;

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
    public String doFirst(String name, int age) {

        System.out.println("业务方法doFirst被执行.....");
        return "jfdsla";
    }

    @Override
    public Student doStudent(String name, int age) {
        System.out.println("业务方法doStudent被执行了");
        return new Student(200);
    }
}
