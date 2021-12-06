package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoFrame extends JFrame {
    private JPanel Order = new JPanel();
    private JPanel PersonInfo = new JPanel();

    InfoFrame(Order order, JButton deleteOrder) {
        super();
        setLayout(new GridLayout(4, 1));
        Customer customer = order.getCostumer();
        super.setTitle("Order from" +
                customer.getFirstName() + " " +
                customer.getSecondName());

        JLabel name = new JLabel("Name: " + order.getCostumer().getFirstName() + " " + order.getCostumer().getSecondName());

        if (order instanceof InternetOrder) {
            Address address = customer.getAddress();
            JLabel Address = new JLabel(
                    "Address: " +
                            address.getZipCode() + ", "
                            + address.getCityName() + ", "
                            + address.getStreetName() + " street, "
                            + address.getBuildingNumber()
                            + address.getBuildingLetter() + ", " +
                            address.getApartmentNumber()
            );
            PersonInfo.add(name);
            PersonInfo.add(Address);
            PersonInfo.setLayout(new GridLayout(2, 1));

        } else if (order instanceof TableOrder) {
            PersonInfo.add(name);
            PersonInfo.setLayout(new GridLayout(1, 1));
        }
        add(PersonInfo);
        getFullInfo(order);
        add(Order);

        JPanel TotalCost = new JPanel();
        TotalCost.setLayout(new GridLayout(1, 2));
        TotalCost.add(new JLabel("Total Cost: "));
        int TotalPrice = 0;
        for (MenuItem item : order.getDishes()) {
            TotalPrice += item.getPrice();
        }
        TotalCost.add(new JLabel(TotalPrice + " ₽"));
        add(TotalCost);

        deleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        add(deleteOrder);
        pack();
    }

    public void getFullInfo(Order order) {
        MenuItem[] items = order.getDishes();
        Order.setLayout(new GridLayout(items.length, 1));
        for (int i = 0; i < items.length; i++) {
            Order.add(new JLabel(
                    "Name: " +
                            items[i].getName() +
                            " \tPrice: " +
                            items[i].getPrice() +
                            " ₽"
            ));
        }
        setVisible(true);
        setResizable(true);
        setSize(200, items.length * 100);
    }
}
