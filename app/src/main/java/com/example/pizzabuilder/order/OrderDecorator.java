package com.example.pizzabuilder.order;

abstract class OrderDecorator implements Order {
    private Order order;

    public OrderDecorator(Order order) {
        this.order = order;
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }
}
