package com.bjpowernode.proxy04;

/**
 * 杨廷甲
 * 2020-12-08
 */
public class TransLogProxy implements Buy {

    //这是一种完全的静态代理的方式，就是所有的功能去实现自己的功能规定接口

    //业务的目标对象，通过接口类型传入自己的业务对象，这个对象就是他接口的实现类的对象
    Buy yewu;

    //切面的对象，这个切面对象就是他的接口实现类的对象，传入是是按照他的·接口的实现类来传入的
    AOP aop;

    public TransLogProxy(Buy yewu, AOP aop) {
        this.yewu = yewu;
        this.aop = aop;
    }

    @Override
    public void buy() {

        //各干各的

        try {
            aop.before();
            yewu.buy();
            aop.after();
        } catch (Exception e) {
            aop.exception();
        }

    }
}
