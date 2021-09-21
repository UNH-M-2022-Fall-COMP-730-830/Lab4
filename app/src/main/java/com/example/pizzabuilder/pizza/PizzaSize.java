package com.example.pizzabuilder.pizza;

public enum PizzaSize {
    LARGE, MEDIUM, SMALL;

    public String getDescription() {
        switch (this) {
            case LARGE:
                return "Large Pizza";
            case MEDIUM:
                return "Medium Pizza";
            case SMALL:
                return "Small Pizza";
            default:
                return "Unknown";
        }
    }

    public double getPrice() {
        switch (this) {
            case LARGE:
                return 15;
            case MEDIUM:
                return 12;
            case SMALL:
                return 10;
            default:
                return 0;
        }
    }
}
