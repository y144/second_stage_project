package com.bjpowernode.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 杨廷甲
 * 2020-12-07
 */

//基于注解完成赋值
//@Component此注解动作相当于<bean id="student" class="com.bjpowernode.pojo.Student">相当于在xml文件中使用bean标签进行创建对象
@Component
public class Student {

    //基于注解完成对成员变量的赋值，@Value()进行简单类型的赋值
    @Value("zhangsann")
    private String name;
    @Value("12")
    private int age;

    @Autowired
    @Qualifier("my_school")//my_school相当于spring的bean工厂生产出的对象名(首先这个对象是要存在的)，拿来注入给当前school@Autowired 和@Qualifier("名称")  它俩放一起用,表示按名称注入引用类型
    private School school;


    public Student() {
        System.out.println("我是学生的无参构造方法。。");
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }


}
