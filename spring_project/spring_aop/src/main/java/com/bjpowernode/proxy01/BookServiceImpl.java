package com.bjpowernode.proxy01;

/**
 * 杨廷甲
 * 2020-12-08
 */

//最原始版本：(只表现出我们需要实现的)实现图书购买，并添加事务的处理
public class BookServiceImpl {

    public void buy(){

        try {
            //事务功能的实现
            System.out.println("事务开区........");

            //主业务的实现
            System.out.println("图书购买业务的实现...........");


            //事务的提交
            System.out.println("事务的提交");
        } catch (Exception e) {
            System.out.println("事务的回滚、、、");
        }
    }
}
