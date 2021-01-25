package com.bjpowernode.proxy05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class AopDynamicProxy {
    //完全使用动态代理的 方式，动态的去创建代理对象，将我们的要实现的业务的对象和公共的切面对象通过参数的形式传入进来，去动态的创建动态代理对象
    public static Object getProxy(Buy yewu,AOP aop){

        return Proxy.newProxyInstance(
                yewu.getClass().getClassLoader()//类加载器
                , yewu.getClass().getInterfaces(),//拦截的所有接口
                new InvocationHandler() {//
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        try {
                            aop.before();

                            obj = method.invoke(yewu, args);

                            aop.after();
                        } catch (Exception e) {
                            aop.exception();
                        }
                        return obj;
                    }
                }
        );
    }
}
