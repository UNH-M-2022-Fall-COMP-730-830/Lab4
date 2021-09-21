package com.example.pizzabuilder.order;

public class Delivery extends OrderDecorator {
    private String address;

    public Delivery(Order order, String address) {
        super(order);
        this.address = address;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Deliver to " + address;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5;
    }
}
