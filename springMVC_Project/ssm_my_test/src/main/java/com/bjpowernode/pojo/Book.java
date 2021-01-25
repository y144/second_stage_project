package com.bjpowernode.pojo;

import java.io.Serializable;

/**
 * 杨廷甲
 * 2020-12-13
 */
public class Book implements Serializable {
    private Integer bookid;
    private String bookname;

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                '}';
    }

    public Integer getBookid() {
        return bookid;
    }

    public Book setBookid(Integer bookid) {
        this.bookid = bookid;
        return this;
    }

    public String getBookname() {
        return bookname;
    }

    public Book setBookname(String bookname) {
        this.bookname = bookname;
        return this;
    }

    public Book(Integer bookid, String bookname) {
        this.bookid = bookid;
        this.bookname = bookname;
    }

    public Book() {
    }
}
