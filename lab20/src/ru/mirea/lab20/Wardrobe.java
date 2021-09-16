package ru.mirea.lab20;

public class Wardrobe extends Furniture {

    public Wardrobe(String material, int price, String color) {
        super(material, price, color);
    }

    @Override
    public String toString() {
        return "Шкаф " + super.toString();
    }
}
