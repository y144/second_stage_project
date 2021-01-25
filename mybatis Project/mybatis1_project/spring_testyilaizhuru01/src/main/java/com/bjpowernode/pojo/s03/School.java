package com.bjpowernode.pojo.s03;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class School {

    private String name;
    private String address;

    public School() {
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public School setName(String name) {
        this.name = name;
        return this;
    }

    public School setAddress(String address) {
        this.address = address;
        return this;
    }
}
