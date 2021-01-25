package com.bjpowernode;

import com.bjpowernode.impl.Agent;
import com.bjpowernode.impl.SuperStarLiu;
import com.bjpowernode.impl.SuperStarZhou;
import org.junit.Test;

/**
 * 杨廷甲
 * 2020-12-04
 */
public class MyTest {

    @Test
    public void test01(){
        Agent agent = new Agent(new SuperStarLiu());
        agent.sing();
    }
}
