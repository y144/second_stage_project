package com.bjpowernode.factory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.OutputStreamWriter;
import java.lang.reflect.Method;

/**
 * 杨廷甲
 * 2020-12-05
 */

//要实现MethodInterceptor接口：因为只有实现了这个接口，才能进行功能方法的拦截，将拦截的方法功能进行增强
public class AgentProxyFactory implements MethodInterceptor {

    //将目标传入进来
    Object target;

    //通过构造方法将目标对象传进来
    public AgentProxyFactory(Object target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        /*
        * 将增强功能的代码写这里
        *Object o：这里是生成的代理对象，一般不用
        *Method method：这是目标对象的方法（也就是父类的方法）
        *Object[] objects：这是目标对象的方法的参数
        *MethodProxy methodProx：这是目标方法的触发操作（一般也不用）
        * */

        //增强的功能
        System.out.println("预定场地【】【】【】【】");
        System.out.println("预定时间；‘；’；‘");
        //目标对象方法的调用
        Object obj = method.invoke(target, objects);
        System.out.println("收费走人，。，。，");
        return obj;
    }


    //动态代理对象的创建
    public Object getAgent(){

        //借助于工具类Enhancer
        Enhancer en = new Enhancer();
        //设置要代理的父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);//调用angent.sing()方法去执行intercept()
        //返回代理对象
        return en.create();//angent->代理对象

    }
}
