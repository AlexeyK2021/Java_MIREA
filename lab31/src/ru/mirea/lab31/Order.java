package ru.mirea.lab31;

public interface Order {
    boolean add(MenuItem AddingItem);
    boolean remove(String itemName);
    int removeAll(String itemName);
    int itemQuantity();
    MenuItem[] getDishes();
    double costTotal();
    int itemQuantity(String itemName);
    int itemQuantity(MenuItem item);
    MenuItem[] getItemsWithoutRepeat();
    String[] dishesNames();
    MenuItem[] sortedDishesByCost();
}
