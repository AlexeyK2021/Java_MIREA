package ru.mirea.lab32;

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
    Customer getCostumer();
    void setCostumer(Customer costumer);
    int getTable();
    void setTable(int Table);
}
