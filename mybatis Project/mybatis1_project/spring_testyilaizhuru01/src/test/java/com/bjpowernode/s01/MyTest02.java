package com.bjpowernode.s01;

import com.bjpowernode.pojo.s03.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class MyTest02 {
    ApplicationContext ac;

    @Before
    public void getAc(){
        ac = new ClassPathXmlApplicationContext("s03/ApplicationContext.xml");
    }

    @Test
    public void test(){
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);
    }
    @Test
    public void test02(){
        Date myDate = (Date) ac.getBean("myDate");
        System.out.println(myDate);
    }
}
