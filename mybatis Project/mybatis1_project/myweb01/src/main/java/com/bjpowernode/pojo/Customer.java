package com.bjpowernode.pojo;

import java.util.List;

/**
 * 杨廷甲
 * 2020-12-03
 */
public class Customer {

    private int id;
    private String name;
    private int age;
    //一方持有多方的集合
    private List<Orders> orderList;

    public Customer(int id, String name, int age, List<Orders> orderList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orderList = orderList;
    }

    public List<Orders> getOrdersList() {
        return orderList;
    }

    public Customer setOrdersList(List<Orders> ordersList) {
        this.orderList = ordersList;
        return this;
    }

    public Customer() {
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orderList=" + orderList +
                '}';
    }

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Customer setAge(int age) {
        this.age = age;
        return this;
    }
}
