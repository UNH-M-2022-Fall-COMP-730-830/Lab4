package com.example.pizzabuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.pizzabuilder.order.Coupon;
import com.example.pizzabuilder.order.Delivery;
import com.example.pizzabuilder.order.Order;
import com.example.pizzabuilder.order.Side;
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
        Order order = new Pizza.Builder(PizzaSize.LARGE)
            .addChicken()
            .build();
        order = new Side(order, "Buffalo Sauce");
        order = new Side(order, "Soda");
        showOrderDescription(order);
    }

    private void secondOrder() {
        Pizza pizza = new Pizza.Builder(PizzaSize.MEDIUM)
            .addPeperoni()
            .build();
        Order order = new Delivery(pizza, "88 Commercial Street, Manchester, NH");
        showOrderDescription(order);
    }

    private void thirdOrder() {
        Order order = new Pizza.Builder(PizzaSize.LARGE)
            .addMushrooms()
            .addTomatoes()
            .addPeppers()
            .build();
        order = new Side(order, "Ranch Sauce");
        order = new Side(order, "French Fries");
        order = new Side(order, "Soda");
        order = new Coupon(order);
        showOrderDescription(order);
    }

    private void fourthOrder() {
        Pizza pizza = new Pizza.Builder(PizzaSize.SMALL)
            .addBacon()
            .addPeperoni()
            .addChicken()
            .build();
        Order delivery = new Delivery(pizza, "88 Commercial Street, Manchester, NH");
        Order orderWithDiscount = new Coupon(delivery);
        showOrderDescription(orderWithDiscount);
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
