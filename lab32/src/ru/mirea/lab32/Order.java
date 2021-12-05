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
    public Customer getCostumer();
    public void setCostumer(Customer costumer);
    public int getTable();
    public void setTable(int table);
}
