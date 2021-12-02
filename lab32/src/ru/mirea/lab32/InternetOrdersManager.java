package ru.mirea.lab32;

import java.util.HashMap;

public class InternetOrdersManager implements OrdersManager {
    private HashMap<String, InternetOrder> OrdersTables = new HashMap<>();

    public void add(String table, InternetOrder order) throws OrderAlreadyAddedException {
        try {
            if (OrdersTables.containsKey(table) && OrdersTables.get(table) != null)
                throw new OrderAlreadyAddedException("The table " + table + " is already occupied!");
            else OrdersTables.put(table, order);
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
    }

    public InternetOrder get(String table) throws IllegalTableNumber {
        if (!OrdersTables.containsKey(table)) {
            throw new IllegalTableNumber(table);
        } else return OrdersTables.get(table);
    }

    public void removeOrder(String table) throws IllegalTableNumber {
        if (!OrdersTables.containsKey(table)) {
            throw new IllegalTableNumber(table);
        } else OrdersTables.remove(table);
    }

    public void addDish(String table, MenuItem dish) throws IllegalTableNumber {
        if (!OrdersTables.containsKey(table)) {
            throw new IllegalTableNumber(table);
        } else OrdersTables.get(table).add(dish);
    }

    @Override
    public int ordersQuantity() {
        return OrdersTables.size();
    }

    @Override
    public Order[] getOrders() {
        return OrdersTables.values().toArray(new InternetOrder[0]);
    }

    @Override
    public int ordersCostSummary() {
        int d = 0;
        for (String str : OrdersTables.keySet())
            d += OrdersTables.get(str).costTotal();
        return d;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int a = 0;
        for (InternetOrder ord : OrdersTables.values())
            a += ord.itemQuantity(itemName);
        return a;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int a = 0;
        for (InternetOrder ord : OrdersTables.values())
            a += ord.itemQuantity(item);
        return a;
    }

}
