package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Orders;

/**
 * 杨廷甲
 * 2020-12-03
 */
public interface OrdersMapper {
    //一对多
    Orders getById(int id);

}
