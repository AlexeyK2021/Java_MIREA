package ru.mirea.lab16;

public final class Drink implements Item{
    private final float price;
    private final String name;
    private final String description;

    public Drink(float price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Drink(String name, String description) {
        this.name = name;
        this.description = description;
        price = 0;
    }

    public float getCost() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
