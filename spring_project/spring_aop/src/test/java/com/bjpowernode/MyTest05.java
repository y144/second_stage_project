package com.bjpowernode;

import com.bjpowernode.proxy05.*;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class MyTest05 {


    @Test
    public void test01(){

        //事务切面的增强
        Buy proxy = (Buy) AopDynamicProxy.getProxy(new BookServiceImpl(), new TransAop());
        proxy.buy();
        proxy.sell();
    }


    @Test
    public void test02(){

        Buy proxy = (Buy) AopDynamicProxy.getProxy(new BookServiceImpl(), new TransAop());
        Buy proxy001 = (Buy) AopDynamicProxy.getProxy(proxy, new LogAop());
        proxy001.sell();
        proxy001.buy();
    }
}
