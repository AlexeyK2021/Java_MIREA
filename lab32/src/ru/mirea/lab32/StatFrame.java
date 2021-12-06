package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;

public class StatFrame extends JFrame {
    public StatFrame(InternetOrdersManager iom, TablesOrdersManager tom) {
        super("Statistics");
        setVisible(true);
        setResizable(true);
        setSize(300, 200);
        setLayout(new GridLayout(3,2));

        add(new JLabel("Internet Orders Info: "));
        add(new JLabel("Table Orders Info: "));

        add(new JLabel("Total orders: " + iom.ordersQuantity()));
        add(new JLabel("Total orders: " + tom.ordersQuantity()));
        add(new JLabel("Total price: " + iom.ordersCostSummary()));
        add(new JLabel("Total price: " + tom.ordersCostSummary()));
    }
}
