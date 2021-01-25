package com.bjpowernode.proxy03;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class LogProxy implements Buy{
    //目标对象
    Buy yewu;

    public LogProxy(Buy yewu) {
        this.yewu = yewu;
    }


    @Override
    public void buy() {
        //在主业务前执行日志记录的功能

        System.out.println("在主业务前进行日志记录的功能");

        yewu.buy();
    }
}
