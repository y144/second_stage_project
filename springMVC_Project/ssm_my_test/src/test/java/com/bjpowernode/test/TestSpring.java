package com.bjpowernode.test;

import com.bjpowernode.pojo.Student;
import com.bjpowernode.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-13
 */
public class TestSpring {

   /* @Test
    public void run1(){
        //加载spring配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext_spring.xml");
        //获取对象
        StudentService as = (StudentService) ac.getBean("studentService");
        //调用方法
        as.findAll();
    }*/



    ApplicationContext ac;
    @Before
    public void getAc(){
        ac = new ClassPathXmlApplicationContext("applicationContext_trans.xml");
    }

    @Test
    public void test01(){
        int flag;

        Student student = new Student(12, "给对方两个", "123@qq.com", 23);
        StudentService userService = ac.getBean(StudentService.class);
        flag = userService.saveStudent(student);
        if (flag > 0){
            System.out.println("Users添加用户成功！！");
        }
    }


}
