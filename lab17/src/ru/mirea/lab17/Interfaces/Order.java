package ru.mirea.lab17.Interfaces;

public interface Order {
    boolean add(Item AddingItem);
    boolean remove(String itemName);
    int removeAll(String itemName);
    int itemQuantity();
    Item[] getDishes();
    double costTotal();
    int itemQuantity(String itemName);
    Item[] getItemsWithoutRepeat();
    String[] dishesNames();
    Item[] sortedDishesByCost();
}
