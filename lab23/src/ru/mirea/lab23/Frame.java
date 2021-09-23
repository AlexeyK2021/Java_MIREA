package ru.mirea.lab23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    JTextArea text = new JTextArea();

    JButton blue = new JButton("Blue");
    JButton red = new JButton("Red");
    JButton black = new JButton("Black");
    JButton TNR = new JButton("Times New Roman");
    JButton Sans = new JButton("MS Sans Serif");
    JButton CN = new JButton("Courier New");
    static String FontNow;
    static String ColorNow;

    Frame() {
        super("Text Editor");
        setVisible(true);
        setSize(500, 500);
        add(text);
        text.setColumns(20);
        text.setRows(10);
        JPanel color = new JPanel();
        color.add(blue);
        color.add(red);
        color.add(black);
        JPanel font = new JPanel();
        font.add(TNR);
        font.add(Sans);
        font.add(CN);
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(color);
        getContentPane().add(font);
        text.setHighlighter();
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorNow = "blue";
            }
        });
    }
}
