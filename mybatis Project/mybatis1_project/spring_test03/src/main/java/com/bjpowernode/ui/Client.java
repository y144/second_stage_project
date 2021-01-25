package com.bjpowernode.ui;



import com.bjpowernode.service.IAccountService;
import com.bjpowernode.service.impl.AccountServiceImpl;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.transform.Source;

/**
 * 杨廷甲
 * 2020-12-06
 */

//模拟一个表现层，用于调用业务层
public class Client {


    //获取spring的Ioc核心容器，并根据id获取我们想要得到的对象
    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as =(IAccountService) ac.getBean("accountService");
        as.saveAccount();

    }
}
