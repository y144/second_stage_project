package com.bjpowernode.pojo;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class Users {

    private int id;
    private String name;

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Users setId(int id) {
        this.id = id;
        return this;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
    }
}
