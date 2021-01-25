package com.bjpowernode.pojo;

/**
 * 杨廷甲
 * 2020-12-12
 */
public class Users {
    private String uname;
    private int age;

    @Override
    public String toString() {
        return "Users{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public Users setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Users setAge(int age) {
        this.age = age;
        return this;
    }

    public Users(String uname, int age) {
        this.uname = uname;
        this.age = age;
    }

    public Users() {
    }
}
