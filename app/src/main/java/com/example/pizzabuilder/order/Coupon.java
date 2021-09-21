package com.example.pizzabuilder.order;

public class Coupon extends OrderDecorator {
    public Coupon(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", -$5 coupon";
    }

    @Override
    public double getPrice() {
        return super.getPrice() - 5;
    }
}
