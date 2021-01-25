package com.bjpowernode;

/**
 * 杨廷甲
 * 2020-12-01
 */
public class Demo {
    public int add(int num1,int num2){
        return num1+num2;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("和是："+demo.add(100, 100));
    }
}
