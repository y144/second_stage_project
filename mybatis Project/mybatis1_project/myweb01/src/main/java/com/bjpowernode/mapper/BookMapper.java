package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Book;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-03
 */
public interface BookMapper {
    //查看全部书
    List<Book> findAll();

    //第二种解决方案
    List<Book> findAllResultMap();
}
