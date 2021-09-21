package com.example.pizzabuilder.order;

public class Side extends OrderDecorator {
    private String name;

    public Side(Order order, String name) {
        super(order);
        this.name = name;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", +" + name;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3;
    }
}
