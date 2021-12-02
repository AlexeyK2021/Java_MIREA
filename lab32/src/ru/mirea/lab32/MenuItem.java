package ru.mirea.lab32;

public abstract class MenuItem {
    protected int price;
    protected String name;
    protected String description;

    public MenuItem(int price, String name, String description) throws IllegalArgumentException {
        if (price < 0 || name.equals("") || description.equals(""))
            throw new IllegalArgumentException("Object of MenuItem has incorrect characteristics!");
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
