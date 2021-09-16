package ru.mirea.lab21;

public class City implements Nameable{
    private String name;

    public City(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
