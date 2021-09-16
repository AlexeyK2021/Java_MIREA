package ru.mirea.lab20;

public abstract class Furniture {
    private String material;
    private int price;
    private String color;

    public Furniture(String material, int price, String color) {
        this.material = material;
        this.price = price;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "{" +
                "Материал:  " + material +
                ", Цена: " + price +
                ", Цвет:" + color +
                "}";
    }
}
