package com.bjpowernode.test;

import com.bjpowernode.pojo.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 杨廷甲
 * 2020-12-07
 */
public class MyTest {

    ApplicationContext ac;

    @Before
    public void getAc(){//加载spring配置文件，并创建bean工厂对象
        ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void test(){//使用bean工厂对象调用getBean()方法，得到我们想要的bean对象
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }
}
