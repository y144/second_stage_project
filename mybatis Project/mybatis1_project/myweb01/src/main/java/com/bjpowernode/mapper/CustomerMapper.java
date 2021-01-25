package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Customer;

/**
 * 杨廷甲
 * 2020-12-03
 */
public interface CustomerMapper {
    //按指定的ID进行查询  多对一的操作
    Customer getById(int id);
}
