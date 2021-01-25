package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 杨廷甲
 * 2020-12-01
 */
public interface UsersMapper {

    //规定数据库访问的操作

    //查询所有用户信息
    public List<Users> findAll();

    //安用户ID查询
    Users findById(int num);

    //按姓名模糊查询
    List<Users> findLikeUsers(String username);

    //按指定的列名进行查询 得需要一个列的列名还有这个列名所对应的的值
    //但是在后面的sql语句中入参会有问题，所以这里使用注解里面指定一个名称(与后面参数名一样或不一样都可以)，就等于说在这两个参数传入的时候给这两个参数起一个名字，然后在调用SQL语句的时候就可以使用名称来替换sql语句中的${columnName}与'%${columnValue}%'， 形成字符串的拼接(这里注解的名称要与后面SQL语句所替换的名称需要保持一致，因为是指定名称进行替换),名字只是一个代号，其实质还是这个传入的参数。
    List<Users> findFiled(@Param("columnName") String columnName, @Param("columnValue") String columnValue);

    //有条件查询
    List<Users> findUsersCondition(Users users);

    //添加新用户
    int insertUsers(Users users);

    //普通更新用户信息(未更新的字段则会自动更新为null)
    int updateUsers(Users users);

    //有条件更新(未更新的字段保持不变)
    int updateCondition(Users users);

    //遍历集合参数
    List<Users>findBySomeId(List list);

    //批量增加
    int insertBatch(List<Users> list);

    //批量删除
    int deleteBatch(List list);

    //指定参数位置进行查询
    List<Users> appointParameterLoc(String name,String sex);

    //添加用户信息入参是Map
    int parameterIsMap(Map map);

    /*
    * 添加用户信息入参是Map
    * int ParameterIsMap(Map map)
    * */

    //查询 返回一个map,封装一个对象。对象的属性与属性的值，以键值对的形式存放在map中
    Map<String,Object> resultMap(int id);
    /*
    * 查询返回一个Map,封装一个对象，对象的属性与属性的值，以键值对的形式存放在map中
    * Map<String,Object> resultMap(int id)
    * */

    //查询返回多个map，一个map就是一个对象
    List<Map<String,Object>> resultMapMany();





}
