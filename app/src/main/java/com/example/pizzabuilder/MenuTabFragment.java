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
        Pizza pizza = new Pizza.Builder(PizzaSize.LARGE)
            .addExtraCheese()
            .build();
        showPizzaDescription(pizza);
    }

    private void makePeperoniPizza() {
        Pizza pizza = new Pizza.Builder(PizzaSize.SMALL)
            .addPeperoni()
            .build();
        showPizzaDescription(pizza);
    }

    private void makeMeatLoversPizza() {
        Pizza pizza = new Pizza.Builder(PizzaSize.SMALL)
            .addPeperoni()
            .addBacon()
            .build();
        showPizzaDescription(pizza);
    }

    private void makeChickenPizza() {
        Pizza pizza = new Pizza.Builder(PizzaSize.MEDIUM)
            .addChicken()
            .build();
        showPizzaDescription(pizza);
    }

    private void makeHawaiianPizza() {
        Pizza pizza = new Pizza.Builder(PizzaSize.MEDIUM)
            .addPineapples()
            .addChicken()
            .addPeppers()
            .build();
        showPizzaDescription(pizza);
    }

    private void makeVeggiePizza() {
        Pizza pizza = new Pizza.Builder(PizzaSize.LARGE)
            .addPeppers()
            .addTomatoes()
            .addMushrooms()
            .build();
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