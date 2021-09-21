package com.example.pizzabuilder.pizza;

import com.example.pizzabuilder.order.Order;

public class Pizza implements Order {
    private PizzaSize size;
    private Boolean cheese;
    private Boolean tomatoes;
    private Boolean peperoni;
    private Boolean bacon;
    private Boolean mushrooms;
    private Boolean chicken;
    private Boolean pineapples;
    private Boolean peppers;

    public Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.tomatoes = builder.tomatoes;
        this.peperoni = builder.peperoni;
        this.bacon = builder.bacon;
        this.mushrooms = builder.mushrooms;
        this.chicken = builder.chicken;
        this.pineapples = builder.pineapples;
        this.peppers = builder.peppers;
    }

    @Override
    public String getDescription() {
        String description = size.getDescription();
        if(cheese)
            description += ", cheese";
        if(bacon)
            description += ", bacon";
        if(tomatoes)
            description += ", tomatoes";
        if(peperoni)
            description += ", peperoni";
        if(mushrooms)
            description += ", mushrooms";
        if(chicken)
            description += ", chicken";
        if(pineapples)
            description += ", pineapples";
        if(peppers)
            description += ", peppers";
        return description;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }

    public static class Builder {
        private PizzaSize size;
        private Boolean cheese = false;
        private Boolean tomatoes = false;
        private Boolean peperoni = false;
        private Boolean bacon = false;
        private Boolean mushrooms = false;
        private Boolean chicken = false;
        private Boolean pineapples = false;
        private Boolean peppers = false;

        public Builder(PizzaSize size) {
            this.size = size;
        }

        public Builder addExtraCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addTomatoes() {
            this.tomatoes = true;
            return this;
        }

        public Builder addPeperoni() {
            this.peperoni = true;
            return this;
        }

        public Builder addBacon() {
            this.bacon = true;
            return this;
        }

        public Builder addChicken() {
            this.chicken = true;
            return this;
        }

        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Builder addPineapples() {
            this.pineapples = true;
            return this;
        }

        public Builder addPeppers() {
            this.peppers = true;
            return this;
        }

        public Pizza build() {
            Pizza pizza = new Pizza(this);
            return pizza;
        }
    }
}
