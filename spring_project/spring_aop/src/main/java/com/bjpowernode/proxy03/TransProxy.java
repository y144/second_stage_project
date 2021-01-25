package com.bjpowernode.proxy03;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class TransProxy implements Buy{


    Buy goumaitushu;

    public TransProxy(Buy goumaitushu) {
        this.goumaitushu = goumaitushu;
    }

    @Override
    public void buy() {

        try {
            System.out.println("开启事务........");

            //让目标对象执行自己的方法
            goumaitushu.buy();

            System.out.println("事务的提交");
        } catch (Exception e) {
            System.out.println("事务的回滚........");
        }
    }
}
