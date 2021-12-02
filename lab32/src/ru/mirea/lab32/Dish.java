package ru.mirea.lab32;

public final class Dish extends MenuItem {

    public Dish(int price, String name, String description) throws IllegalArgumentException {
        super(price, name, description);
    }

    public Dish(String name, String description) throws IllegalArgumentException {
        super(0, name, description);
    }

}
