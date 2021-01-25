package com.bjpowernode.pojo;

/**
 * 杨廷甲
 * 2020-12-05
 */
//自定义的泛型，T就是在调用的时候被替换掉的的类型，在调用时就无须类型判断，无须类型转换
public class Pair<T> {
    //在创建是和一般的实体类的创建是一样的过程

    T max;
    T min;

    public Pair() {
    }

    public Pair(T max, T min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    public T getMax() {
        return max;
    }

    public Pair<T> setMax(T max) {
        this.max = max;
        return this;
    }

    public T getMin() {
        return min;
    }

    public Pair<T> setMin(T min) {
        this.min = min;
        return this;
    }
}
