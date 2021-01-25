package com.bjpowernode;

import com.bjpowernode.s01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class MyTest01 {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s01/ApplicationContext.xml");

        //使用接口返回增强功能后的业务类  这里得到的代理对象时通过 绑定了切面的动态代理对象 增强后的代理对象
        SomeService service = (SomeService) ac.getBean("someService");
        service.doSome("程琪", 12);
    }
}
