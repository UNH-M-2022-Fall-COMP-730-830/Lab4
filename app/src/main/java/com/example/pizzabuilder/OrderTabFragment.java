package com.example.pizzabuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.pizzabuilder.order.Order;
import com.example.pizzabuilder.pizza.Pizza;
import com.example.pizzabuilder.pizza.PizzaSize;
import com.example.pizzabuilder.views.PizzaMenuView;

public class OrderTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.<PizzaMenuView>findViewById(R.id.order1).setOnButtonClickListener(view1 -> {
            firstOrder();
        });

        view.<PizzaMenuView>findViewById(R.id.order2).setOnButtonClickListener(view1 -> {
            secondOrder();
        });

        view.<PizzaMenuView>findViewById(R.id.order3).setOnButtonClickListener(view1 -> {
            thirdOrder();
        });

        view.<PizzaMenuView>findViewById(R.id.order4).setOnButtonClickListener(view1 -> {
            fourthOrder();
        });
    }

    private void firstOrder() {
        // LARGE Pizza with Chicken
        Order order = new Pizza(PizzaSize.LARGE, false, false, false, false, false, true, false, false);
        order.setSides(new String[]{"Buffalo Sauce", "Soda"});
        showOrderDescription(order);
    }

    private void secondOrder() {
        // MEDIUM Pizza with Peperoni
        Order order = new Pizza(PizzaSize.MEDIUM, false, false, true, false, false, false, false, false);
        order.setDeliveryAddress("88 Commercial Street, Manchester, NH");
        showOrderDescription(order);
    }

    private void thirdOrder() {
        // LARGE Pizza with Mushrooms + Tomatoes + Peppers
        Order order = new Pizza(PizzaSize.LARGE, false, true, false, false, true, false, false, true);
        order.setSides(new String[]{"Ranch Sauce", "French Fries", "Soda"});
        order.setCoupon(true);
        showOrderDescription(order);
    }

    private void fourthOrder() {
        // SMALL Pizza with Bacon + Peperoni + Chicken
        Order order = new Pizza(PizzaSize.SMALL, false, false, true, true, false, false, false, false);
        order.setDeliveryAddress("88 Commercial Street, Manchester, NH");
        order.setCoupon(true);
        showOrderDescription(order);
    }

    private void showOrderDescription(@NonNull Order order) {
        AlertDialog alert = new AlertDialog.Builder(requireContext())
            .setTitle("Order Total $" + order.getPrice())
            .setMessage(order.getDescription())
            .setCancelable(true)
            .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel())
            .create();
        alert.show();
    }
}
