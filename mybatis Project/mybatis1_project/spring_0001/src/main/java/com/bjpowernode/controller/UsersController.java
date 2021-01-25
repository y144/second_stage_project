package com.bjpowernode.controller;

import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.UsersService;


/**
 * 杨廷甲
 * 2020-12-07
 */
public class UsersController {

    //调用业务逻辑层
    public UsersService uService;

    public UsersController setuService(UsersService uService) {
        this.uService = uService;
        return this;
    }

    public void insertUsers(){
        uService.insert(new Users());
    }
}
