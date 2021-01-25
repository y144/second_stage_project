package com.bjpowernode.s03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 杨廷甲
 * 2020-12-10
 */

@Aspect
public class MyAspect {


    @Around(value = "execution(* com.bjpowernode.s03.SomeServiceImpl.doThree(..))")
    public Object myAspect(ProceedingJoinPoint pjp)throws Throwable{

        //要根据目标方法传入的参数中姓名是张三，才会进行环绕通知处理，否则什么都不做

        String name = null;
        Object obj = null;
        //取得参数
        Object[] objp = pjp.getArgs();
        if (objp != null && objp.length > 1){
            name = (String) objp[0];
            if ("张三".equals(name)){
                //进行目标方法的访问的限制
                //前置增强
                System.out.println("在业务方法执行前的功能的增强");
                //调用业务方法
                obj = pjp.proceed();//拿到目标方法的返回值
                System.out.println("在主业务方法执行后的功能的增强");
            }else {
                System.out.println("无法进行业务增强和业务处理");
            }
        }
        return obj+"fdls";//此处就是直接对目标方法的返回值直接进行操作
    }
}
