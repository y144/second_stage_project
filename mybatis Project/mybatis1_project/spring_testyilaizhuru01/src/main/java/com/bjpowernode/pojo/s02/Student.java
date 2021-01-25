package com.bjpowernode.pojo.s02;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //使用spring注入 类中的成员变量就必须要有setter方法 spring容器使用setter方法对属性进行操作
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }
}
