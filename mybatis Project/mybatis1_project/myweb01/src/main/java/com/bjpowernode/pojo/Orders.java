package com.bjpowernode.pojo;

/**
 * 杨廷甲
 * 2020-12-03
 */
public class Orders {

    private int id;
    private String orderNumber;
    private double orderPrice;

    //多方持有一方的对象
    private Customer customer;


    public Orders() {
    }

    public Orders(int id, String orderNumber, double orderPrice, Customer customer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Orders setId(int id) {
        this.id = id;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Orders setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public Orders setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Orders setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public String toString() {
        return "OrdersMapper{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderPrice=" + orderPrice +
                ", customer=" + customer +
                '}';
    }
}
