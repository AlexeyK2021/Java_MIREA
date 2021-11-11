package ru.mirea.lab16;

public class TablesOrderManager {
    Order[] orders = new Order[0];
    int[] tables = new int[0];

    TablesOrderManager() {
    }

    public void add(Order order, int tableNumber) {
        Order[] NewOrder = new Order[orders.length + 1];
        int[] NewTables = new int[tables.length + 1];

        if (orders.length != 0)
            System.arraycopy(orders, 0, NewOrder, 0, orders.length);

        if (tables.length != 0)
            System.arraycopy(tables, 0, NewTables, 0, tables.length);

        NewOrder[orders.length] = order;
        NewTables[tables.length] = tableNumber;

        orders = NewOrder;
        tables = NewTables;
    }

    public Order getOrder(int tableNumber) {
        for (int number : tables)
            if (number == tableNumber)
                return orders[number];
        return null;
    }

    public void addDish(Item dish, int tableNumber) {
        for (int number : tables)
            if (number == tableNumber)
                orders[number].add(dish);

    }

    public void removeOrder(int tablenumber) {
        Order[] NewOrder = new Order[orders.length - 1];
        for (int i = 0; i < orders.length; i++) {
            if (i == tablenumber) {
                System.arraycopy(orders, 0, NewOrder, 0, i);
                System.arraycopy(orders, i + 1, NewOrder, i, NewOrder.length - i);
            }
        }
        orders = NewOrder;
    }

    public Order[] getOrders() {
        return orders;
    }

    public double ordersCostSummary() {
        double cost = 0;
        for (Order o : orders) {
            cost += o.costTotal();
        }
        return cost;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (Order o : orders) {
            count += o.dishQuantity(dishName);
        }
        return count;
    }
}
