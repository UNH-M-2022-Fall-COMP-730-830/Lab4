package com.example.pizzabuilder.order;

public class Order {
    private String[] sides;
    private String deliveryAddress;
    private boolean coupon;

    public Order() {
        sides = new String[0];
        deliveryAddress = null;
        coupon = false;
    }

    public String getDescription() {
        String description = "";

        // Sides description
        for (String side : getSides()) {
            description += ", +" + side;
        }

        // Delivery description
        if (getDeliveryAddress() != null) {
            description += ", Deliver to " + getDeliveryAddress();
        }

        // Coupon description
        if (hasCoupon()) {
            description += ", -$5 coupon";
        }

        return description;
    }

    public double getPrice() {
        double price = 0;

        // Sides price
        price += getSides().length * 3; // +$3 for each side

        // Delivery price
        if (getDeliveryAddress() != null) {
            price += 5; // +$5 for delivery
        }

        // Coupon price
        if (hasCoupon()) {
            price -= 5; // -$5 discount
        }

        return price;
    }

    public String[] getSides() {
        return sides;
    }

    public void setSides(String[] sides) {
        this.sides = sides;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public boolean hasCoupon() {
        return coupon;
    }

    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }
}