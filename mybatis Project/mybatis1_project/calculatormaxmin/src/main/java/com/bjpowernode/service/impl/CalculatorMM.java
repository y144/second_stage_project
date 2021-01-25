package com.bjpowernode.service.impl;

import com.bjpowernode.pojo.Pair;

/**
 * 杨廷甲
 * 2020-12-05
 */
public class CalculatorMM {
    //求极值运算
    public static <T extends Comparable> Pair<T> calculator(T [] arr){
        //判断数组是否为空，如果数组为空则不作任何处理
        if (arr==null || arr.length==0){
            return null;
        }

        T max=arr[0];
        T min=arr[0];

        //使用循环进行比较
        for (int i = 0; i < arr.length; i++) {
            //取最小值
            if (min.compareTo(arr[i])>0){//大于零则说明现在的最小值比数组中值的大，那就说明数组中的值是小值，而我们需要的就是小值那么就进行交换把小值放入到min的变量中
                min = arr[i];
            }
            if (max.compareTo(arr[i])<0){
                max = arr[i];
            }
        }
        return new Pair<>(max,min);
    }
}
