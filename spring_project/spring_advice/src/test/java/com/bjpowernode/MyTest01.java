package com.bjpowernode;

import com.bjpowernode.service.BookService;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookService proxy  = (BookService) context.getBean("bookService");
        proxy.buy("赵云", "平凡的世界", 88.88);
        proxy.comment("赵宇", "这是一本很好的书，希望有更多的人去看看这本书");
    }
}
