package com.bjpowernode.s02;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class Student {
    private int age;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }
}
