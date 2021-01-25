package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UsersDao;
import com.bjpowernode.pojo.Users;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class UsersDaoImpl implements UsersDao {
    @Override
    public int insert(Users users) {
        System.out.println("插入用户操作成功；；");
        return 0;
    }
}
