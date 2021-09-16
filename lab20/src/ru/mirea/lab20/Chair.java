package ru.mirea.lab20;

public class Chair extends Furniture {
    public Chair(String material, int price, String color) {
        super(material, price, color);
    }

    @Override
    public String toString() {
        return "Стул " + super.toString();
    }
}
