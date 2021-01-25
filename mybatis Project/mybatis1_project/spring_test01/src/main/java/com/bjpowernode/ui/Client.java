package com.bjpowernode.ui;


import com.bjpowernode.dao.IAccountDao;
import com.bjpowernode.service.IAccountService;
import com.bjpowernode.service.impl.AccountServiceImpl;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.transform.Source;

/**
 * 杨廷甲
 * 2020-12-06
 */

//模拟一个表现层，用于调用业务层
public class Client {

    /*
    * ApplicationContext 接口的三个常用实现类：
    *   ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话加载不了
    *   FileSystemXmlApplicationContext:可以加载磁盘任意路径下的配置文件(必须有访问权限)
    *   AnnotationConfigApplicationContext:它是用于读取注解创建文件
    * */

    /*
    * 核心容器的两个接口引发的问题：
    *   ApplicationContext:它在创建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件，马上就创建配置文件中配置的对象(使用场景：单例对象   在实际开发中使用的更多)
    *   BeanFactory:他在构件核心容器时，创建对象时采用的策略是采用延迟加载的方式，也就是说什么时候根据id获取对象了，什么时候在真正创建对象(使用场景：多例对象)
    *   (在实际开发中根据情况选择)
    * */

    //获取spring的Ioc核心容器，并根据id获取我们想要得到的对象
    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as =(IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);//两种方式，创建两个对象
        System.out.println(as);
        System.out.println(adao );
        //as.saveAccount();
    }
}
