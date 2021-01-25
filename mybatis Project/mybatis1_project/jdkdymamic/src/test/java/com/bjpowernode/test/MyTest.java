package com.bjpowernode.test;

import com.bjpowernode.Impl.SuperStarLiu;
import com.bjpowernode.factory.AgentProxyFactory;
import com.bjpowernode.service.IService;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class MyTest {


    @Test
    public void test01(){
        //创建代理对象
        IService agent = (IService) new AgentProxyFactory(new SuperStarLiu()).getAgent();

        //调用代理对象的方法
        agent.sing();
        agent.dance();
    }

}
