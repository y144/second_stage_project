package com.bjpowernode.ui;

import com.bjpowernode.factory.BeanFactory;
import com.bjpowernode.service.impl.AccountServiceImpl;

/**
 * 杨廷甲
 * 2020-12-06
 */

//模拟一个表现层，用于调用业务层
public class Client {

    public static void main(String[] args) {
//        AccountServiceImpl as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {//表名此时的对象是一个多例对象
            AccountServiceImpl as =(AccountServiceImpl) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
            //多例对象：此时执行中可以看到每个对象都有一个独立的实例，从而保证了类对象在创建时，重新初始化他的类中的属性，这是这个i始终都是1，不管有多少个service对象来访问时，由于对象都是新创建的，所以不会有变化

            //单例对象：在这种情况下，这个对象只被创建一次，从而类中的成员只被初始化一次，在这种前提之下，除了第一次是正常的1以外后边都会是改变后的值，所以在多个线程访问或者多个对象访问时，由于对象的实例只有一个，这时候如果要操作类成员时，类成员在方法中能够进行改变的时候，单例对象有线程
        }


    }
}
