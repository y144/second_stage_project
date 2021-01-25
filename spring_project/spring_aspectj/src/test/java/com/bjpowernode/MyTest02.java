package com.bjpowernode;

import com.bjpowernode.s02.SomeService;
import com.bjpowernode.s02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.Provider;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class MyTest02 {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s02/ApplicationContext.xml");
        //使用接口返回增强功能后的业务类
        SomeService service = (SomeService) ac.getBean("someService");
        System.out.println(service.getClass());
        String doFirst = service.doFirst("张三", 11);
        System.out.println("doFirst方法在方法调用这里，返回值是----"+doFirst);
    }

    @Test
    public void test02(){
        ApplicationContext av = new ClassPathXmlApplicationContext("s02/ApplicationContext.xml");
        //使用接口返回增强功能后的业务类
        SomeService someService = (SomeService) av.getBean("someService");
        System.out.println(someService.getClass());
        Student student = someService.doStudent("长得撒",11);
        System.out.println("在方法调用这里，返回值是"+student.getAge());
    }
}
