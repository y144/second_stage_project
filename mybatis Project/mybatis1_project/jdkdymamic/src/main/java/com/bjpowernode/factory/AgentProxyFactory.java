package com.bjpowernode.factory;

import com.bjpowernode.service.IService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class AgentProxyFactory {

    //要传入目标对象
    public IService superStar;

    //使用构造方法将目标对象传入
    public AgentProxyFactory(IService superStar){
        this.superStar = superStar;
    }

   //生成动态代理对象，并返回
    public Object getAgent(){

        /*
        *ClassLoader loader:类加载器，将类的字节码文件送给jvm,让他去执行
        *Class<?>[] interfaces:拦截目标对象的所有接口，目的是得到这些接口中的所有方法进行功能的增强
        *InvocationHandler h:名为调用处理器，其实就是将代理功能的代码写在这里，进行功能的增强
        * */
        return Proxy.newProxyInstance(superStar.getClass().getClassLoader(), superStar.getClass().getInterfaces(), new InvocationHandler() {

            /*
            *上面创建代理对象的最后一个参数，就是需要创建(new)一个调用处理器对象，然后将增强的功能代码写在这里
        *proxy:就是生成的代理对象
        *method:就是目标对象的的方法
        *args:就是目标对象的参数列表
        * */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("预定场地；’；");
            System.out.println("预定时间；‘；’");
            method.invoke(superStar);
            System.out.println("清算费用。、。");
            return null;
        }
    });
}


}
