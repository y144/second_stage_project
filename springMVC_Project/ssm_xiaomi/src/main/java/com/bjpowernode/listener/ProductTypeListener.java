package com.bjpowernode.listener;

import com.bjpowernode.pojo.ProductType;
import com.bjpowernode.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * 杨廷甲
 * 2020-12-16
 * 把读取所有类别的这个功能 放在监听器里的好处是，当我的程序一加载(这个应用程序部署一发布)后，所有的商品类别就能通过这个方法productTypeService.getAll()拿到商品类别的list集合,把它放到全局通讯作用域，通过全局通讯作用域，那么我们在(整个项目)哪里就都可以使用这个集合
 */

@WebListener //通过这个注解，来注册监听器的使用
public class ProductTypeListener implements ServletContextListener {

    //要从ProductTypeService中调用getAll()这个方法，所以要注入ProductTypeService的这个对象就可以了，，但是！ spring容器也是也是监听器创建，所有他还不能提供依赖注入的功能，spring一加载对象时创建成功的，但是不能依赖注入   那么就需要手工取出productTypeService对象
    /*@Autowired
    ProductTypeService productTypeService;*/


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //手工去productTypeService的对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService service = (ProductTypeService) ac.getBean("ProductTypeServiceImpl");


        //监听器启动的时候通过productTypeService调用getAll()方法得到所有的商品类型
        List<ProductType> list = service.getAll();
        //拿到所有的商品类型后，把它放入全局的通讯作用域里，那么当打开增加页面的时候，商品类型的下拉列表中有商品类型的集合
        servletContextEvent.getServletContext().setAttribute("ptlist",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
