package com.bjpowernode.pojo.s01;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class Student {
    private String mame;
    private int age;

    public Student() {
        System.out.println("我是学生的无参构造方法，我现在被调用");
    }


    @Override
    public String toString() {
        return "Student{" +
                "mame='" + mame + '\'' +
                ", age=" + age +
                '}';
    }
}
