package com.bjpowernode.test;

import com.bjpowernode.factory.UsbKingFactory;
import com.bjpowernode.hanfler.MySellHandler;
import com.bjpowernode.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 杨廷甲
 * 2020-12-04
 */
public class MainShop {
    public static void main(String[] args) {
        //创建代理对象
        //1.创建目标对象,给他创建代理
        UsbKingFactory factory = new UsbKingFactory();
        //2/创建一个invocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);
        //3.创建代理对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),handler);
        //4.通过代理执行方法
        float price = proxy.sell(1);
        System.out.println("通过动态代理，调用的方法"+price);
    }
}
