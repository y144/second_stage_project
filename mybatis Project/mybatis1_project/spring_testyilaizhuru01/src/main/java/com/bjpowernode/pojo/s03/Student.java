package com.bjpowernode.pojo.s03;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class Student {
    private String name;
    private int age;
    private School school;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public Student setSchool(School school) {
        this.school = school;
        return this;
    }

    //没有对应的成员变量 但有setter方法
    public void setEmail(String email){
        System.out.println("我是setEmail方法；；；；；");
    }

}
