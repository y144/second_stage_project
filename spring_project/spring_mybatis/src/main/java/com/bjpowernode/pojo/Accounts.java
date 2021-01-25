package com.bjpowernode.pojo;

import java.net.PortUnreachableException;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class Accounts {
    private int aid;
    private String aname;
    private String acontent;

    @Override
    public String toString() {
        return "Accounts{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", acontent='" + acontent + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public Accounts setAid(int aid) {
        this.aid = aid;
        return this;
    }

    public String getAname() {
        return aname;
    }

    public Accounts setAname(String aname) {
        this.aname = aname;
        return this;
    }

    public String getAcontent() {
        return acontent;
    }

    public Accounts setAcontent(String acontent) {
        this.acontent = acontent;
        return this;
    }

    public Accounts(int aid, String aname, String acontent) {
        this.aid = aid;
        this.aname = aname;
        this.acontent = acontent;
    }

    public Accounts() {
    }
}
