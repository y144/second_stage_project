package com.bjpowernode.proxy05;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class BookServiceImpl implements Buy {
    @Override
    public void buy() {
        System.out.println("图书购买业务的实现.....");
    }

    @Override
    public void sell() {
        System.out.println("售卖图书新业务......");
    }
}
