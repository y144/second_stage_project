package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Users;

/**
 * 杨廷甲
 * 2020-12-04
 */
public interface UsersMapper {

    //按id查询
    Users getById(int id);

    //更新用户
    int update(Users users);
}
