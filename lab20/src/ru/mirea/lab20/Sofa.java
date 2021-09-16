package ru.mirea.lab20;

public class Sofa extends Furniture {
    public Sofa(String material, int price, String color) {
        super(material, price, color);
    }

    @Override
    public String toString() {
        return "Диван " + super.toString();
    }
}
