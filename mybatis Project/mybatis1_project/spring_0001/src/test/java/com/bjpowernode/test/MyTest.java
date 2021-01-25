package com.bjpowernode.test;

import com.bjpowernode.controller.UsersController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class MyTest {

    ApplicationContext ac;

    @Before
    public void getAc(){
        ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void test(){
        UsersController uController = (UsersController) ac.getBean("uController");
        System.out.println(uController);
    }
}
