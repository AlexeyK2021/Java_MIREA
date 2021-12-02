package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateFrame extends JFrame {
    CreateFrame(ArrayList<InternetOrder> internetOrders) {
        setVisible(true);
        setLayout(new GridLayout(3, 1));
        setSize(300, 300);
        JPanel Person = new JPanel();
        JTextField name = new JTextField();
        JTextField SecondName = new JTextField();
        JTextField Age = new JTextField();

        Person.setLayout(new GridLayout(4, 2));
        Person.add(new Label("Name: "));
        Person.add(name);
        Person.add(new Label("Second Name: "));
        Person.add(SecondName);
        Person.add(new Label("Age: "));
        Person.add(Age);
        add(Person);

        JPanel Address = new JPanel();

        JTextField CityName = new JTextField();
        JTextField ZIP = new JTextField();
        JTextField streetName = new JTextField();
        JTextField buildingNumber = new JTextField();
        JTextField buildingLetter = new JTextField();
        JTextField apartmentNumber = new JTextField();

        Address.setLayout(new GridLayout(6, 2));
        Address.add(new Label("City name: "));
        Address.add(CityName);
        Address.add(new Label("ZIP code: "));
        Address.add(ZIP);
        Address.add(new Label("Street: "));
        Address.add(streetName);
        Address.add(new Label("House number: "));
        Address.add(buildingNumber);
        Address.add(new Label("House letter: "));
        Address.add(buildingLetter);
        Address.add(new Label("Apartment number: "));
        Address.add(apartmentNumber);

        add(Address);

        JPanel Items = new JPanel();
        Items.setLayout(new GridLayout(4, 3));
        JCheckBox Salad = new JCheckBox("Salad with shrimps");
        JCheckBox Olivier = new JCheckBox("Olivier");
        JCheckBox Lobsters = new JCheckBox("Lobsters");
        JCheckBox FriedEggs = new JCheckBox("Fried egg");
        JCheckBox Pizza = new JCheckBox("Pizza");
        JCheckBox Burger = new JCheckBox("Burger");

        JCheckBox Beer = new JCheckBox("Beer");
        JCheckBox Juice = new JCheckBox("Juice");
        JCheckBox Tea = new JCheckBox("Tea");
        JCheckBox Coffee = new JCheckBox("Coffee");

        ArrayList<MenuItem> orders = new ArrayList<>();
        Salad.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Salad.isSelected()) {
                    orders.add(new Dish(1500, "Salad", "Salad with shrimps"));
                } else orders.remove(new Dish(1500, "Salad", "Salad with shrimps"));
            }
        });

        Olivier.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Olivier.isSelected()) {
                    orders.add(new Dish(1500, "Olivier", "Classic Olivier"));
                } else orders.remove(new Dish(1500, "Olivier", "Classic Olivier"));
            }
        });
        Lobsters.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Lobsters.isSelected()) {
                    orders.add(new Dish(1500, "Lobsters", "Fried Lobsters"));
                } else orders.remove(new Dish(1500, "Lobsters", "Fried Lobsters"));
            }
        });
        FriedEggs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (FriedEggs.isSelected()) {
                    orders.add(new Dish(1500, "FriedEggs", "Good FriedEggs"));
                } else orders.remove(new Dish(1500, "FriedEggs", "Good FriedEggs"));
            }
        });
        Pizza.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Pizza.isSelected()) {
                    orders.add(new Dish(1500, "Pizza", "Pizza with pineapples"));
                } else orders.remove(new Dish(1500, "Pizza", "Pizza with pineapples"));
            }
        });
        Burger.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Burger.isSelected()) {
                    orders.add(new Dish(1500, "Burger", "Burger with fresh meat"));
                } else orders.remove(new Dish(1500, "Burger", "Burger with fresh meat"));
            }
        });

        Beer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Beer.isSelected()) {
                    orders.add(new Drink(400, "Beer", "Czech beer", DrinkTypeEnum.BEER));
                } else orders.remove(new Drink(400, "Beer", "Czech beer", DrinkTypeEnum.BEER));
            }
        });
        Juice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Juice.isSelected()) {
                    orders.add(new Drink(400, "Juice", "Apple Juice", DrinkTypeEnum.JUICE));
                } else orders.remove(new Drink(400, "Juice", "Apple Juice", DrinkTypeEnum.JUICE));
            }
        });
        Tea.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Tea.isSelected()) {
                    orders.add(new Drink(400, "Tea", "Green Tea", DrinkTypeEnum.GREEN_TEA));
                } else orders.remove(new Drink(400, "Tea", "Green Tea", DrinkTypeEnum.GREEN_TEA));
            }
        });
        Coffee.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Coffee.isSelected()) {
                    orders.add(new Drink(400, "Coffee", "Cappuccino", DrinkTypeEnum.COFFEE));
                } else orders.add(new Drink(400, "Coffee", "Cappuccino", DrinkTypeEnum.COFFEE));
            }
        });

        Items.add(Salad);
        Items.add(Olivier);
        Items.add(Lobsters);
        Items.add(FriedEggs);
        Items.add(Pizza);
        Items.add(Burger);
        Items.add(Beer);
        Items.add(Juice);
        Items.add(Tea);
        Items.add(Coffee);

        add(Items);

        JPanel FunctionalButtons = new JPanel();
        FunctionalButtons.setLayout(new GridLayout(1, 2));
        JButton Save = new JButton("Save");
        JButton Cancel = new JButton("Cancel");
        FunctionalButtons.add(Save);
        FunctionalButtons.add(Cancel);

        add(FunctionalButtons);

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer(
                        name.getText(),
                        SecondName.getText(),
                        Integer.parseInt(Age.getText()),
                        new Address(CityName.getText(),
                                Integer.parseInt(ZIP.getText()),
                                streetName.getText(),
                                Integer.parseInt(buildingNumber.getText()),
                                buildingLetter.getText().toCharArray()[0],
                                Integer.parseInt(apartmentNumber.getText())
                        ));
                InternetOrder order = new InternetOrder();
                for (MenuItem item : orders) {
                    order.add(item);
                }
                internetOrders.add(order);
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
    }
}
