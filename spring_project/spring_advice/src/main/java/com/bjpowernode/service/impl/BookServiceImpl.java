package com.bjpowernode.service.impl;

import com.bjpowernode.service.BookService;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class BookServiceImpl implements BookService {
    @Override
    public boolean buy(String userName, String bookName, double price) {
        System.out.println("购买图书功能的实现");

        System.out.println(userName+"购买了图书"+bookName);
        System.out.println(userName+"增加了积分"+(int)(price/10));
        System.out.println("图书购买完毕，向物流开始下单");
        System.out.println("图书购买业务结束");
        return false;
    }

    @Override
    public void comment(String userName, String comments) {
        System.out.println("发表评论的功能");
        System.out.println(userName+"发表图书评论"+comments);
        System.out.println("图书评论业务结束");
    }
}
