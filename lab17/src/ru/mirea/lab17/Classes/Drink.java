package ru.mirea.lab17.Classes;

import ru.mirea.lab17.Interfaces.Item;

public final class Drink implements Item {
    private final int price;
    private final String name;
    private final String description;

    public Drink(int price, String name, String description) throws IllegalArgumentException {
        if (price < 0 || name.equals("") || description.equals(""))
            throw new IllegalArgumentException("Object of Drink has incorrect characteristics!");
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Drink(String name, String description) throws IllegalArgumentException {
        if (name.equals("") || description.equals(""))
            throw new IllegalArgumentException("Object of Drink has incorrect characteristics!");
        this.name = name;
        this.description = description;
        price = 0;
    }

    public int getCost() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
