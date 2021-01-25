package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.ProductInfoExample;
import com.bjpowernode.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-15
 */

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    //必须的有productInfoMapper的对象，service层有数据访问层的对象
    @Autowired
    ProductInfoMapper productInfoMapper;


    //1.查询全部
    @Override
    public List<ProductInfo> getAll() {
        //调用 按条件查询 的方法，这里的条件就可以new出来一个空对象，表示没有条件
        return productInfoMapper.selectByExample(new ProductInfoExample());

    }

    //2.进行分页的实现
    @Override  //返回的结果全部给pageInfo他会将查询的数据进行全部装载好
    public PageInfo<ProductInfo> splitPage(int page, int pageSize) {
         /*
         * 借助于分页插件实现分页的功能
         *      1.首先在SqlMapConfig.xml文件中注册插件
         *      2.借助于pageHelper完成分页页码和分页条数的设置
         *      3.借助pageInfo封装所有的分页数据：当前页、总页数、当前页产品集合、总行数
         *      注意：在执行数据库查询之前，必须先设置pageHelper,这是一个硬性的要求
         * */

         /*//只要使用查询就要先创建Example的对象
        ProductInfoExample example = new ProductInfoExample();

        *//*
        * 在这里提前设置如果是新增商品后，那么新增的商品出现在所有商品的第一条(进行业务优化)
        *对商品进行按商品id进行降序排序，
        * *//*

        //使用example进行排序  通过example对象将我们 在这里设置的排序条件传入到ProductInfoMapper.xml文件中的selectByExample这个查询条件中的order by ${orderByClause}大括号中的内容，进行排序
        example.setOrderByClause("p_id desc");

        //进行查询的动作
        //根据上面的要求，在执行数据库查询之前，必须先设置pageHelper,这是一个硬性的要求
        PageHelper.startPage(page,pageSize);//这个操作会有代码污染，因为在查找前要先设置插件的功能，遵循插件的设动规范，但是影响不大
        //完成查询的操作
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查到的结果集给pageInfo对象，他会把我们需要的所有的数据装载好
        PageInfo<ProductInfo> info = new PageInfo<>(list);//将查到的集合给pageInfo对象
        return info;*/


        /*============================下面是使用Ajax实现分页================================*/

        /*
         * 借助于分页插件实现分页的功能
         *      1.首先在SqlMapConfig.xml文件中注册插件
         *      2.借助于pageHelper完成分页页码和分页条数的设置
         *      3.借助pageInfo封装所有的分页数据：当前页、总页数、当前页产品集合、总行数
         *      注意：在执行数据库查询之前，必须先设置pageHelper,这是一个硬性的要求
         * */

        //只要进行数据库按条件查询，则必须创建xxxExample的对象(但凡有逆向工程生成的必然要先这么写)
        ProductInfoExample example = new ProductInfoExample();

        //设置降序排序
        example.setOrderByClause("p_id desc");

        //完查询的操作
        //注意：在执行数据库查询之前，必须先设置pageHelper,这是一个硬性的要求，使用插件工具中的pageHelper提前设置当前的页数，以及当前页的条数
        PageHelper.startPage(page,pageSize);  //构件好这个limit(分页) 然后在放在查询语句中才可以
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //查询完将数据封装在pageInfo类中
        PageInfo<ProductInfo> info = new PageInfo<>(list);
        return info;
    }

    //删除商品
    @Override
    public int delete(int pid) {
        return productInfoMapper.deleteByPrimaryKey(pid);
    }

    //批量删除商品
    @Override
    public int deleteBatch(String[] pids) {
        return productInfoMapper.deleteBatch(pids);
    }

    //增加商品
    @Override
    public int insert(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    //更新商品

    @Override
    public int update(ProductInfo info) {
        return productInfoMapper.updateByPrimaryKeySelective(info);
    }

    //安主键查找
    @Override
    public ProductInfo getById(Integer pid) {
        return productInfoMapper.selectByPrimaryKey(pid);
    }
}
