package com.bjpowernode.impl;

import com.bjpowernode.service.IService;

/**
 * 杨廷甲
 * 2020-12-04
 */
//代理对象，通过代理对象实现请明星刘德华来唱歌，以及一些时间预定、费用结算的功能，这些功能就是在重写的sing()方法中
public class Agent implements IService {

    //目标对象
    public IService superStar;

    //通过构造方法从类外传入目标对象 在sing()方法中，传来谁就是谁在表演
    public Agent(IService superStar){
        this.superStar=superStar;
    }

    @Override
    public void sing() {

        System.out.println("预定场地==========");
        System.out.println("预订时间----------");

        //来请刘德华来表演
        /*SuperStarLiu liu = new SuperStarLiu();
        liu.sing();*/
        superStar.sing();

        System.out.println("演出完后进行费用的结算--后续的处理");

    }
}
