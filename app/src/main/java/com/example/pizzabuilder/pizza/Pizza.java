package com.example.pizzabuilder.pizza;

import com.example.pizzabuilder.order.Order;

public class Pizza extends Order {
    private PizzaSize size;
    private Boolean cheese;
    private Boolean tomatoes;
    private Boolean peperoni;
    private Boolean bacon;
    private Boolean mushrooms;
    private Boolean chicken;
    private Boolean pineapples;
    private Boolean peppers;

    public Pizza(PizzaSize size, Boolean cheese, Boolean tomatoes, Boolean peperoni, Boolean bacon, Boolean mushrooms, Boolean chicken, Boolean pineapples, Boolean peppers) {
        this.size = size;
        this.cheese = cheese;
        this.tomatoes = tomatoes;
        this.peperoni = peperoni;
        this.bacon = bacon;
        this.mushrooms = mushrooms;
        this.chicken = chicken;
        this.pineapples = pineapples;
        this.peppers = peppers;
    }

    @Override
    public String getDescription() {
        String description = size.getDescription();
        if (cheese)
            description += ", cheese";
        if (bacon)
            description += ", bacon";
        if (tomatoes)
            description += ", tomatoes";
        if (peperoni)
            description += ", peperoni";
        if (mushrooms)
            description += ", mushrooms";
        if (chicken)
            description += ", chicken";
        if (pineapples)
            description += ", pineapples";
        if (peppers)
            description += ", peppers";
        return description + super.getDescription();
    }

    @Override
    public double getPrice() {
        return size.getPrice() + super.getPrice();
    }
}
