package com.bjpowernode;

import com.bjpowernode.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-09
 */
public class MyTest {

    @Test
    public void test01(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
