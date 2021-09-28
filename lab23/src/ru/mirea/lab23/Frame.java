package ru.mirea.lab23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JTextArea text = new JTextArea();
    private JButton blue = new JButton("Blue");
    private JButton red = new JButton("Red");
    private JButton black = new JButton("Black");
    private JButton TNR = new JButton("Times New Roman");
    private JButton Sans = new JButton("MS Sans Serif");
    private JButton CN = new JButton("Courier New");

    Frame() {
        super("Text Editor");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel color = new JPanel();
        color.add(blue);
        color.add(red);
        color.add(black);

        JPanel font = new JPanel();
        font.add(TNR);
        font.add(Sans);
        font.add(CN);

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(text);
        getContentPane().add(color);
        getContentPane().add(font);


        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.BLUE);
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.RED);
            }
        });
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.BLACK);
            }
        });
        TNR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            }
        });
        Sans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
            }
        });
        CN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setFont(new Font("Courier New", Font.PLAIN, 14));
            }
        });
    }
}
