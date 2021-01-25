package com.bjpowernode;

import com.bjpowernode.proxy02.BookServiceImpl;
import com.bjpowernode.proxy02.SubBookServiceImpl;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class MyTest02 {


    @Test
    public void test(){
        BookServiceImpl book = new SubBookServiceImpl();

        book.buy();
    }
}
