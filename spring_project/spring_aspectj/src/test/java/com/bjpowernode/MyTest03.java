package com.bjpowernode;

import com.bjpowernode.s03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class MyTest03 {


    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s03/ApplicationContext.xml");
        SomeService service = (SomeService) ac.getBean("someService");
        System.out.println(service.getClass());
        String three = service.doThree("张三", 12);// therr 相当于切面中的返回值Object obj
        System.out.println("在方法调用这里，返回值是"+three);
    }

    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s03/ApplicationContext.xml");
        SomeService service = (SomeService) ac.getBean("someService");
        System.out.println(service.getClass());
        String three = service.doThree("张三22", 12);// therr 相当于切面中的返回值Object obj
        System.out.println("在方法调用这里，返回值是"+three);
    }
}
