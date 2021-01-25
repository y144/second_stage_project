package com.bjpowernode.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 杨廷甲
 * 2020-12-07
 */

@Component("my_school") //通过注解创建对象，并给创建的对象起名字
public class School {
    @Value("北京航空航天大学")//通过注解给简单类型赋值
    private String name;
    @Value("北京市大兴区凉水河二街千年公寓")
    private String address;

    public School() {
    }


    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
