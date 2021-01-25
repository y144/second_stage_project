package com.bjpowernode;

import com.bjpowernode.proxy03.BookServiceImpl;
import com.bjpowernode.proxy03.Buy;
import com.bjpowernode.proxy03.LogProxy;
import com.bjpowernode.proxy03.TransProxy;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class MyTest03 {

    @Test
    public void test01(){

        //测试创建子类的代理对象
        Buy proxy = new TransProxy(new BookServiceImpl());
        proxy.buy();
    }

    @Test
    public void test02(){
        Buy proxy = new LogProxy(new TransProxy(new BookServiceImpl()));
        proxy.buy();
    }
}
