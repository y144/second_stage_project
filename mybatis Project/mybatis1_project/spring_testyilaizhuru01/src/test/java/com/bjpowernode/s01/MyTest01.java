package com.bjpowernode.s01;

import com.bjpowernode.pojo.s02.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class MyTest01 {

    ApplicationContext ac;


    @Before//创建一个容器对象
    public void getAc(){
        ac = new ClassPathXmlApplicationContext("s02/ApplicationContext.xml");
    }
    @Test
    public void test(){
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);
    }
}
