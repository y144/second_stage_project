package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-01
 */
public class MyTest {
    @Test
    public void testDemo1(){
        Demo demo = new Demo();
        System.out.println("test1:"+demo.add(25, 666));
    }

    @Test
    public void testDemo(){
        Demo demo = new Demo();
        System.out.println("test2:"+demo.add(25, 66));
    }

    //断言测试
}
