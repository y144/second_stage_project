package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 杨廷甲
 * 2020-11-30
 */
public interface UsersMapper {
    //规定数据库访问的操作

    //查询所有用户信息
    public List<Users> findAll();

    //查询指定用户信息
    public Users findById(int num);

    //按名称进行模糊查询
    List<Users> findByName(String name);

    //按不同的列名进行查询
    //使用注解指定一个名称，可以一样可以不一样，就等于在给参数的时候，在这里起一个名字，调用的时候就可以使用这个名称来替代 后面查询语句中的占位符，为当前替换的名称占据一个位置，类似于一个占位符的功能
    List<Users> getByColumn(@Param("columnName") String columnName, @Param("columnValue") String columnValue);

    //添加用户
    int insert(Users users);

    //多条件查询
    //以传进来的成员变量，是否有值来决定是否增加条件，有就拼接条件，没有就不拼接
    List<Users> getByCondition(Users users);

    //普通更新操作
    int update(Users users);

    //有条件更新
    int updateCondition(Users users);

    //遍历集合参数
    List<Users> findByUids(List list);

    //批量增加
    int insertUsersBatch(List<Users> list);

    //批量删除
    int deleteUsersBaych(List list);
}
