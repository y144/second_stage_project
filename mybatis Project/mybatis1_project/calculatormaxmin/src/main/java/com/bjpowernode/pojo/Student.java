package com.bjpowernode.pojo;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class Student implements Comparable<Student> {
    private String name;
    private  Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
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

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override//此方法就是用来指定比较属性的（规则）
    public int compareTo(Student o) {
        //String实现了Comparable接口，所以他可以直接调用ComparTo()方法进行比较
        //但是八种基本类型没有实现这个接口所以，处理时可以进行相减看是否大于零来进行处理
        //return this.name.compareTo(o.name);
        //return this.age - o.age;
        return new Integer(this.age).compareTo(new Integer(o.age));
    }
}
