package ru.mirea.lab20;

public class Table extends Furniture {
    public Table(String material, int price, String color) {
        super(material, price, color);
    }

    @Override
    public String toString() {
        return "Стол " + super.toString();
    }
}
