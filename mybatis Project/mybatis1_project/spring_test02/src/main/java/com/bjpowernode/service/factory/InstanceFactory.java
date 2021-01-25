package com.bjpowernode.service.factory;

import com.bjpowernode.service.IAccountService;
import com.bjpowernode.service.impl.AccountServiceImpl;

/**
 * 杨廷甲
 * 2020-12-06
 */

//模拟一个工厂类，(该类可能存在与jar包中，我们无法通过修改源码的方式来提供默认构造函数)
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
