package com.bjpowernode;

import com.bjpowernode.s03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-10
 */
public class MyTest05 {


    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s05/ApplicationContext.xml");
        SomeService service = (SomeService) ac.getBean("someService");
        System.out.println(service.getClass());
        String three = service.doThree("张三", 12);// therr 相当于切面中的返回值Object obj

    }


}
