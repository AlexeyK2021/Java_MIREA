package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame {
    public ArrayList<InternetOrder> internetOrders = new ArrayList<>();

    Frame() {
        super("Restaurant control panel");
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700, 700);

        JPanel InternetOrder = new JPanel();
        JButton addIO = new JButton("ADD");
        JButton delIO = new JButton("DELETE");

        InternetOrder.add(addIO);
        InternetOrder.add(delIO);

        InternetOrder.setLayout(new GridLayout(3, 1));

        ArrayList<JButton> ordersLabels = new ArrayList<>();

        for (int i = 0; i < internetOrders.size(); i++) {
            JButton order = new JButton("Order from " +
                    internetOrders.get(i).getCostumer().getFirstName() + " " +
                    internetOrders.get(i).getCostumer().getSecondName());
            Order order1 = internetOrders.get(i);
            order.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new InfoFrame(
                            getFullName(order1).toString(),
                            "Order from " +
                                    order1.getCostumer().getFirstName() + " " +
                                    order1.getCostumer().getSecondName()
                    );
                }
            });
            ordersLabels.add(order);
        }
        for (JButton Jl : ordersLabels) {
            InternetOrder.add(Jl);
        }
        add(InternetOrder);

        addIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateFrame(internetOrders);
            }
        });
    }


    public StringBuilder getFullName(Order order) {
        MenuItem[] items = order.getDishes();
        StringBuilder OrderAndDishes = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            OrderAndDishes.append("Name: ")
                    .append(items[i].getName())
                    .append("\tPrice: ")
                    .append(items[i].getPrice());
        }
        return OrderAndDishes;
    }
}
