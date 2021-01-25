package com.bjpowernode.pojo;

import java.util.Date;

/**
 * 杨廷甲
 * 2020-11-30
 */
public class Users {
    private int id;
    private String userName;
    private Date birthday;
    private String sex;
    private String address;

    public Users() {
    }

    public Users(String userName, Date birthday, String sex, String address) {
        this.userName = userName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Users(int id, String userName, Date birthday, String sex, String address) {
        this.id = id;
        this.userName = userName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public Users setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Users setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Users setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Users setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Users setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
