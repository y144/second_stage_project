package com.bjpowernode.service.impl;


import com.bjpowernode.service.IAccountService;

/**
 * 杨廷甲
 * 2020-12-06
 */
//账户的业务层的实现类
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    //业务层调用持久层
    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了.......");
    }
}
