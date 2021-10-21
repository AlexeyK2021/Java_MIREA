package ru.mirea.lab15;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300,300);

        Menu file = new Menu();
        file.add("File");

        MenuBar menuBar= new MenuBar();
        menuBar.add(file);
        setMenuBar(menuBar);
    }
}
