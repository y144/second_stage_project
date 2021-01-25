package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UsersDao;
import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.UsersService;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class UsersServiceImpl implements UsersService {

    public UsersDao udao;

    public UsersServiceImpl setUdao(UsersDao udao) {
        this.udao = udao;
        return this;
    }

    @Override
    public int insert(Users u) {
        return udao.insert(u);
    }
}
