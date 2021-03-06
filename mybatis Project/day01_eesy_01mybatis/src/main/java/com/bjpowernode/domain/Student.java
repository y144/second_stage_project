package com.bjpowernode.domain;



import java.util.Date;

/**
 * 杨廷甲
 * 2020-11-29
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private Date age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emali='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmali() {
        return email;
    }

    public Student setEmali(String emali) {
        this.email = emali;
        return this;
    }

    public Date getAge() {
        return age;
    }

    public Student setAge(Date age) {
        this.age = age;
        return this;
    }

    public Student(int id, String name, String emali, Date age) {
        this.id = id;
        this.name = name;
        this.email = emali;
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, String emali, Date age) {
        this.name = name;
        this.email = emali;
        this.age = age;
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
