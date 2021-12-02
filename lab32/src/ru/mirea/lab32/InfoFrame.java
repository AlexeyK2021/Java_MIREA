package ru.mirea.lab32;

import javax.swing.*;

public class InfoFrame extends JFrame {
    private String text;

    InfoFrame(String text, String OrderName) {
        super("Info about" + OrderName);
        this.text = text;
    }

}
