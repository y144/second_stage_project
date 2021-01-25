package com.bjpowernode.hanfler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 杨廷甲
 * 2020-12-04
 */

//必须实现InvocationHandler接口来完成代理类要做的功能(1.调用目标方法 2,功能增强)
public class MySellHandler implements InvocationHandler {

    private Object target = null;
    //动态代理，目标对象时活动的，不是固定的，需要传入进来，传入谁就给谁创建代理
    public MySellHandler(Object target) {
        //给目标对象去赋值
        this.target = target;
    }

    //Method method:反射的方法对象对象，通过invoke
    //Object[] args:目标方法的参数
    //Object proxy:代理对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;

        res = method.invoke(target,args);//执行目标方法


        if (res != null){
            Float price = (Float) res;
            price = price + 25;
            res = price;
        }
        return res;
    }
}
