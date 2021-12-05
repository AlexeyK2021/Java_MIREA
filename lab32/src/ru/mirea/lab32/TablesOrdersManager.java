package ru.mirea.lab32;

public class TablesOrdersManager implements OrdersManager {
    TableOrder[] orders = new TableOrder[0];

    TablesOrdersManager() {
    }

    public void add(TableOrder tableOrder, int tableNumber) throws OrderAlreadyAddedException {
        for (Order o : orders) {
            if (o.getTable() == tableNumber)
                throw new OrderAlreadyAddedException("The table " + tableNumber + " is already occupied!");
        }
        TableOrder[] newTableOrder = new TableOrder[orders.length + 1];
        if (orders.length != 0)
            System.arraycopy(orders, 0, newTableOrder, 0, orders.length);

        tableOrder.setTable(tableNumber);
        newTableOrder[orders.length] = tableOrder;
        orders = newTableOrder;
    }

    public TableOrder getOrder(int tableNumber) throws IllegalTableNumber {
        for (TableOrder to : orders) {
            if (to.getTable() == tableNumber) {
                return to;
            }
        }
        throw new IllegalTableNumber(String.valueOf(tableNumber));
    }

    public void addDish(MenuItem dish, int tableNumber) throws IllegalTableNumber {
        for (TableOrder to : orders) {
            if (to.getTable() == tableNumber) {
                to.add(dish);
            }
        }
        throw new IllegalTableNumber(String.valueOf(tableNumber));
    }

    public void removeOrder(int tableNumber) throws IllegalTableNumber {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getTable() == tableNumber) {
                TableOrder[] newTableOrder = new TableOrder[orders.length - 1];
                System.arraycopy(orders, 0, newTableOrder, 0, i);
                System.arraycopy(orders, i + 1, newTableOrder, i, newTableOrder.length - i);

                orders = newTableOrder;
                return;
            }
        }
        throw new IllegalTableNumber(String.valueOf(tableNumber));
    }

    @Override
    public int ordersQuantity() {
        return orders.length;
    }

    @Override
    public TableOrder[] getOrders() {
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for (TableOrder o : orders) {
            cost += o.costTotal();
        }
        return cost;
    }

    @Override
    public int itemsQuantity(String dishName) {
        int count = 0;
        for (TableOrder o : orders) {
            count += o.itemQuantity(dishName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (TableOrder o : orders) {
            count += o.itemQuantity(item);
        }
        return count;
    }

}
