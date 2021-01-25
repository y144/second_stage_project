package com.bjpowernode.proxy02;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class SubBookServiceImpl extends BookServiceImpl {

    //重写父类方法，加入事务功能，进行功能的增强


    @Override
    public void buy() {
        try {
            System.out.println("事务的开启。。。。。");
            super.buy();
            System.out.println("事务的提交.....");
        } catch (Exception e) {
            System.out.println("事务的回滚。。");
        }
    }
}
