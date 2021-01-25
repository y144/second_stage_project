package com.bjpowernode.Impl;

import com.bjpowernode.service.IService;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class SuperStarZhou implements IService {
    @Override
    public void sing() {
        System.out.println("我是周润发。。。我正在唱歌；’；‘");
    }

    @Override
    public void dance() {
        System.out.println("我是周润发，我正在跳舞。、。、");
    }
}
