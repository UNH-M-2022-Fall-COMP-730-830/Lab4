package com.example.pizzabuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.pizzabuilder.pizza.Pizza;
import com.example.pizzabuilder.pizza.PizzaSize;
import com.example.pizzabuilder.views.PizzaMenuView;

public class MenuTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.<PizzaMenuView>findViewById(R.id.bigCheese).setOnButtonClickListener(view1 -> {
            makeCheesePizza();
        });

        view.<PizzaMenuView>findViewById(R.id.peperoni).setOnButtonClickListener(view1 -> {
            makePeperoniPizza();
        });

        view.<PizzaMenuView>findViewById(R.id.meatLovers).setOnButtonClickListener(view1 -> {
            makeMeatLoversPizza();
        });

        view.<PizzaMenuView>findViewById(R.id.chicken).setOnButtonClickListener(view1 -> {
            makeChickenPizza();
        });

        view.<PizzaMenuView>findViewById(R.id.veggie).setOnButtonClickListener(view1 -> {
            makeVeggiePizza();
        });

        view.<PizzaMenuView>findViewById(R.id.hawaiian).setOnButtonClickListener(view1 -> {
            makeHawaiianPizza();
        });
    }

    private void makeCheesePizza() {
        // LARGE Pizza with Extra cheese
        Pizza pizza = new Pizza(PizzaSize.LARGE, true, false, false, false, false, false, false, false);
        showPizzaDescription(pizza);
    }

    private void makePeperoniPizza() {
        // SMALL Pizza with Peperoni
        Pizza pizza = new Pizza(PizzaSize.SMALL, false, false, true, false, false, false, false, false);
        showPizzaDescription(pizza);
    }

    private void makeMeatLoversPizza() {
        // SMALL Pizza with Peperoni + Bacon + Chicken
        Pizza pizza = new Pizza(PizzaSize.SMALL, false, false, true, true, false, true, false, false);
        showPizzaDescription(pizza);
    }

    private void makeChickenPizza() {
        // MEDIUM Pizza with Chicken
        Pizza pizza = new Pizza(PizzaSize.MEDIUM, false, false, false, false, false, true, false, false);
        showPizzaDescription(pizza);
    }

    private void makeHawaiianPizza() {
        // MEDIUM Pizza with Pineapples + Chicken + Peppers
        Pizza pizza = new Pizza(PizzaSize.MEDIUM, false, false, false, false, false, true, true, true);
        showPizzaDescription(pizza);
    }

    private void makeVeggiePizza() {
        // LARGE Pizza with Peppers + Tomatoes + Mushrooms
        Pizza pizza = new Pizza(PizzaSize.LARGE, false, true, false, false, true, false, false, true);
        showPizzaDescription(pizza);
    }

    private void showPizzaDescription(@NonNull Pizza pizza) {
        AlertDialog alert = new AlertDialog.Builder(requireContext())
                .setTitle("Here is Your Pizza")
                .setMessage(pizza.getDescription())
                .setCancelable(true)
                .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel())
                .create();
        alert.show();
    }
}