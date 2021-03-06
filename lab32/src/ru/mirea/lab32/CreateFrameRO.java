package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class CreateFrameRO extends JFrame {
    public CreateFrameRO(TablesOrdersManager restaurantOrders) {
        super("Creating restaurant order");
        setVisible(true);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        setSize(500, 500);

        JPanel Person = new JPanel();
        JTextField Name = new JTextField();
        JTextField SecondName = new JTextField();
        JTextField Age = new JTextField();
        JTextField Table = new JTextField();

        Person.setLayout(new GridLayout(4, 2));
        Person.add(new Label("Name: "));
        Person.add(Name);
        Person.add(new Label("Second Name: "));
        Person.add(SecondName);
        Person.add(new Label("Age: "));
        Person.add(Age);
        Person.add(new JLabel("Table number :"));
        Person.add(Table);
        add(Person);

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
                } else orders.remove(new Drink(400, "Coffee", "Cappuccino", DrinkTypeEnum.COFFEE));
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
        FunctionalButtons.setLayout(new BoxLayout(FunctionalButtons,BoxLayout.X_AXIS));
        JButton Save = new JButton("Save");
        JButton Cancel = new JButton("Cancel");
        FunctionalButtons.add(Save);
        FunctionalButtons.add(Cancel);

        add(FunctionalButtons);

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TableOrder order = new TableOrder();
                    order.setCostumer(new Customer(
                                    Name.getText(),
                                    SecondName.getText(),
                                    Integer.parseInt(Age.getText()),
                                    new Address()
                            )
                    );
                    for (MenuItem item : orders) {
                        order.add(item);
                    }
                    restaurantOrders.add(order, Integer.parseInt(Table.getText()));
                } catch (NumberFormatException NFE) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error in typed information!", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                } catch (OrderAlreadyAddedException OAAE) {
                    JOptionPane.showMessageDialog(new JFrame(), "Order already added!", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                setVisible(false);
                dispose();
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
