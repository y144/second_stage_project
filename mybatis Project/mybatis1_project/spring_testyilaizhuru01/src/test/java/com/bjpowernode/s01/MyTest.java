package com.bjpowernode.s01;

import com.bjpowernode.pojo.s01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class MyTest {

    @Test
    public void test01(){
        /*//创建学生对象
        Student stu = new Student();
        System.out.println(stu);*/

        //通过spring容器来进行对象的创建

        //1、创建spring容器对象，创建出一个容器出来
        ApplicationContext ac = new ClassPathXmlApplicationContext("s01/ApplicationContext.xml");
        //2.使用容器对象调用getBean()方法，通过spring的相应配置文件中的bean标签中的id的属性值来取出容器为我们创建好的对象
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);
    }

}
