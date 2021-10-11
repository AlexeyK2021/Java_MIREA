package ru.mirea.lab10;

public class Shirt {
    private String number;
    private String name;
    private String color;
    private String size;

    public Shirt(String number, String name, String color, String size) {
        this.number = number;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return number + "," + name + "," + color + "," + size;
    }
}
