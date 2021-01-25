package com.bjpowernode;

import com.bjpowernode.proxy04.*;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class MyTest04 {


    @Test
    public void test01() {
        //测事务
        Buy proxy = new TransLogProxy(new BookServiceImpl(), new TransAop());
        proxy.buy();
    }

    @Test
    public void test02(){
        //测日志
        Buy proxy = new TransLogProxy(new BookServiceImpl(), new LogAop());
        proxy.buy();
    }

    @Test
    public void test03(){

        //日志 事务一起测
        Buy proxy = new TransLogProxy(new TransLogProxy(new BookServiceImpl(), new TransAop()), new LogAop());
        proxy.buy();
    }

}
