package com.bjpowernode.service.impl;


import com.bjpowernode.service.IAccountService;

import java.util.Date;

/**
 * 杨廷甲
 * 2020-12-06
 */
//账户的业务层的实现类
public class AccountServiceImpl implements IAccountService {


    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    //业务层调用持久层
    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了......."+name+","+age+","+birthday);
    }
}
