package com.bjpowernode.test;

import com.bjpowernode.Impl.CarShow;
import com.bjpowernode.Impl.SuperStarLiu;
import com.bjpowernode.factory.AgentProxyFactory;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class MyTest {
    @Test
    public void test01(){

        //子类代理没有实现接口
        AgentProxyFactory factory = new AgentProxyFactory(new SuperStarLiu());
        SuperStarLiu agent = (SuperStarLiu) factory.getAgent();
        agent.sing();

        //汽车展销类的代理
        AgentProxyFactory factory1 = new AgentProxyFactory(new CarShow());
        CarShow agent1 = (CarShow) factory1.getAgent();
        String s = agent1.ShowCar(100);
        System.out.println(s);
    }
}
