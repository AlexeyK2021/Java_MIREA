package ru.mirea.lab13;

public class Complex {
    String value;

    Complex() {
        value = "0+0i";
    }

    Complex(int real, int image) {
        value = real + (image > 0 ? "+" : "") + image + "i";
    }

    public String getValue() {
        return value;
    }
}
