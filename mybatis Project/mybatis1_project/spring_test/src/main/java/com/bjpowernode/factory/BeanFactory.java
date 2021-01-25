package com.bjpowernode.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 杨廷甲
 * 2020-12-06
 */

//一个创建Bean对象的工厂
    //bean:在计算机语言中，有可重用组件的意思
    //javabean:(用java语言编写的可重用组件) 它不等于实体类，javabean的范围要远大于实体类，实体类只是可重用组件的一部分，业务层和持久层都可以看做是可重用组件


    //他就是创建我们的service和dao对象的
    /*如何创建呢
    *   1.需要一个配置文件来配置我们的service和dao
    *       (配置的内容：1.全限定类型2.和这个全限定类名的唯一标识，
    *          唯一标识=全限定类名)
    *          配置文件的创建可以使用两种方式，xml(Spring)文件和properties(相对简单点)
    *   2.通过读取配置文件中的内容(类的全限定类名)，反射创建对象
    *
    * */
 //使用工厂模式创建对象
public class BeanFactory {
    //定义一个porperties对象
    private static Properties props;

    //****定义一个Map将我们要创建的对象存储起来，我们把它称之为容器
    private static Map<String,Object> beans;




    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);


            //***那么就还需要实例化容器
            beans = new HashMap<String, Object>();
            //***取出配置文件中所有的key
            Enumeration keys = props.keys();
            //***变量这个枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }


    //***根据bean 的名称获取对象，这个对象已经是单例的了
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

   /* //根据bean的名称获取bean对象
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();//鉴于以上分析，我么可能不需要多例对象，但是在这里创建对象的时候使用了newInstance(),表名每次都会调用构造函数创建对象，，所以我们只需要每次都是同一个对象就够了，那就需要将程序进行调整，前提是我么的对象只能newInstance一次，z这是就需要一个容器将创建的对象存起来
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/

}
