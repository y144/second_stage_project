package com.bjpowernode.pojo;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class Users {

    private int userid;
    private String uname;
    private String upass;

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public Users setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getUname() {
        return uname;
    }

    public Users setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public String getUpass() {
        return upass;
    }

    public Users setUpass(String upass) {
        this.upass = upass;
        return this;
    }

    public Users(int userid, String uname, String upass) {
        this.userid = userid;
        this.uname = uname;
        this.upass = upass;
    }

    public Users() {
    }
}
