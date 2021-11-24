package ru.mirea.lab17.Orders.Managers;

import ru.mirea.lab17.Exceptions.IllegalTableNumber;
import ru.mirea.lab17.Exceptions.OrderAlreadyAddedException;
import ru.mirea.lab17.Interfaces.Item;
import ru.mirea.lab17.Orders.InternetOrder;
import ru.mirea.lab17.Orders.RestaurantOrder;

import java.util.HashMap;

public class OrderManager {
    private HashMap<String, InternetOrder> OrdersTables = new HashMap<>();

    RestaurantOrder[] orders = new RestaurantOrder[0];
    int[] tables = new int[0];

    OrderManager() {
    }

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

    public void addDish(String table, Item dish) throws IllegalTableNumber {
        if (!OrdersTables.containsKey(table)) {
            throw new IllegalTableNumber(table);
        } else OrdersTables.get(table).add(dish);
    }

    public InternetOrder[] getInternetOrders() {
        return OrdersTables.values().toArray(new InternetOrder[0]);
    }

    public double TotalCostInternetOrders() {
        double d = 0;
        for (String str : OrdersTables.keySet())
            d += OrdersTables.get(str).costTotal();
        return d;
    }

    public int QuantityOfDishInAllInternetOrders(String itemName) {
        int a = 0;
        for (InternetOrder ord : OrdersTables.values())
            a += ord.itemQuantity(itemName);
        return a;
    }

    public void add(RestaurantOrder restaurantOrder, int tableNumber) throws OrderAlreadyAddedException {
        boolean isOccupied = false;
        for (int i : tables) {
            if (i == tableNumber) {
                isOccupied = true;
                break;
            }
        }
        if (isOccupied) throw new OrderAlreadyAddedException("The table " + tableNumber + " is already occupied!");
        else {
            RestaurantOrder[] newRestaurantOrder = new RestaurantOrder[orders.length + 1];
            int[] NewTables = new int[tables.length + 1];

            if (orders.length != 0)
                System.arraycopy(orders, 0, newRestaurantOrder, 0, orders.length);

            if (tables.length != 0)
                System.arraycopy(tables, 0, NewTables, 0, tables.length);

            newRestaurantOrder[orders.length] = restaurantOrder;
            NewTables[tables.length] = tableNumber;

            orders = newRestaurantOrder;
            tables = NewTables;
        }
    }

    public RestaurantOrder getOrder(int tableNumber) throws IllegalTableNumber {
        boolean isExist = false;
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] == tableNumber) {
                isExist = true;
                break;
            }
        }
        if (!isExist) throw new IllegalTableNumber(String.valueOf(tableNumber));
        else {
            for (int number : tables)
                if (number == tableNumber)
                    return orders[number];

            return null;
        }
    }

    public void addDish(Item dish, int tableNumber) throws IllegalTableNumber {
        boolean isExist = false;
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] == tableNumber) {
                isExist = true;
                break;
            }
        }
        if (!isExist) throw new IllegalTableNumber(String.valueOf(tableNumber));
        else {
            for (int number : tables)
                if (number == tableNumber)
                    orders[number].add(dish);

        }
    }

    public void removeOrder(int tableNumber) throws IllegalTableNumber {
        boolean isExist = false;
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] == tableNumber) {
                isExist = true;
                break;
            }
        }
        if (!isExist) throw new IllegalTableNumber(String.valueOf(tableNumber));
        else {
            RestaurantOrder[] newRestaurantOrder = new RestaurantOrder[orders.length - 1];
            for (int i = 0; i < orders.length; i++) {
                if (i == tableNumber) {
                    System.arraycopy(orders, 0, newRestaurantOrder, 0, i);
                    System.arraycopy(orders, i + 1, newRestaurantOrder, i, newRestaurantOrder.length - i);
                }
            }
            orders = newRestaurantOrder;
        }
    }

    public RestaurantOrder[] getOrders() {
        return orders;
    }

    public double ordersCostSummary() {
        double cost = 0;
        for (RestaurantOrder o : orders) {
            cost += o.costTotal();
        }
        return cost;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (RestaurantOrder o : orders) {
            count += o.itemQuantity(dishName);
        }
        return count;
    }
}
