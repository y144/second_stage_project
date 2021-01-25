package com.bjpowernode.service;

import com.bjpowernode.pojo.ProductInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-15
 */
public interface ProductInfoService {

    //查询全部商品
    List<ProductInfo> getAll();


    //进行分页查询，根据分页插件写分页工能
    // (插件里面有提供详细的需要的插件的内容(主要有pageHelper提供用来进行分页设置的工具类，里面会有很多分页对用的已经写好的方法;pageInfo是用来封装数据的工具类))
    PageInfo<ProductInfo> splitPage(int page, int pageSize);

    //根据主键删除商品
    int delete(int pid);

    //批量删除
    int deleteBatch(String pids[]);


    //增加商品
    int insert(ProductInfo productInfo);

    //更新商品
    int update(ProductInfo info);

    //根据主键查商品
    public ProductInfo getById(Integer pid);
}
