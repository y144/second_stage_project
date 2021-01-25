package com.bjpowernode.s01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 杨廷甲
 * 2020-12-08
 */

//@Aspect 当添加在类上时，表示此类是一个切面类就会在AspectJ来扫描时 会把当前这个类当做看成是一个切面类来施加切面类的相应功能
@Aspect
public class MyAspect {

    /*
    *在此切面类中，有实现切面功能的方法，此方法会被织入相应的业务逻辑方法中
    * 实现切面功能方法中的规范
    * 1.方法的访问权限是public
    * 2.方法没有返回值
    * 3.方法的名称是自定义的
    * 4.方法，没有参数，就算有参数也是固定的参数(JoinPoint:它代表目标方法 就能得到目标方法中的签名，以及它所有的参数  如果有此参数 他必是所有参数中的第一个位置)
    *
    *
    *为了指定切入的时机，使用@before注解来指明在在业务逻辑执行前施加切面功能
    *位置：@before在当前的方法上是前置通知
    * 参数：execution()来指明要切入到什么包下的什么类中的什么方法，就是我们的切入点表达式
    *
    * */
    /*@Before(value = "execution(public void com.bjpowernode.s01.SomeServiceImpl.doSome(String,int))")
    public void myAspect(){
        System.out.println("我是前置日志通知........");
    }*/

    /*@Before(value = "execution( void com.bjpowernode.s01.SomeServiceImpl.doSome(..))")
    public void myAspect(){
        System.out.println("我是前置日志通知........");
    }*/

    /*@Before(value = "execution( * com.bjpowernode.s01.*.*(..))")
    public void myAspect(){
        System.out.println("我是前置日志通知........");
    }*/

    @Before(value = "execution( * *..s01.*.*(..))")
    public void myAspect(JoinPoint jp){

        System.out.println("目标对象方法的签名"+jp.getSignature());

        //得到方法的所有参数

        System.out.println("我是前置日志通知........");
    }
}
