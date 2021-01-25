package com.bjpowernode.service;

/**
 * 杨廷甲
 * 2020-12-08
 */
public interface BookService {

    public boolean buy(String userName,String bookName,double price);
    public void comment(String userName,String comments);

}
