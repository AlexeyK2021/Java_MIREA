package ru.mirea.lab31;

public class TablesOrdersManager implements OrdersManager {
    TableOrder[] orders = new TableOrder[0];
    int[] tables = new int[0];

    TablesOrdersManager() {
    }

    public void add(TableOrder tableOrder, int tableNumber) throws OrderAlreadyAddedException {
        boolean isOccupied = false;
        for (int i : tables) {
            if (i == tableNumber) {
                isOccupied = true;
                break;
            }
        }
        if (isOccupied) throw new OrderAlreadyAddedException("The table " + tableNumber + " is already occupied!");
        else {
            TableOrder[] newTableOrder = new TableOrder[orders.length + 1];
            int[] NewTables = new int[tables.length + 1];

            if (orders.length != 0)
                System.arraycopy(orders, 0, newTableOrder, 0, orders.length);

            if (tables.length != 0)
                System.arraycopy(tables, 0, NewTables, 0, tables.length);

            newTableOrder[orders.length] = tableOrder;
            NewTables[tables.length] = tableNumber;

            orders = newTableOrder;
            tables = NewTables;
        }
    }

    public TableOrder getOrder(int tableNumber) throws IllegalTableNumber {
        boolean isExist = false;
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] == tableNumber) {
                isExist = true;
                break;
            }
        }
        if (!isExist) throw new IllegalTableNumber(String.valueOf(tableNumber));
        else {
            int index = 0;
            for (int number : tables)
                if (number == tableNumber)
                    return orders[index];
                else index++;

            return null;
        }
    }

    public void addDish(MenuItem dish, int tableNumber) throws IllegalTableNumber {
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
            TableOrder[] newTableOrder = new TableOrder[orders.length - 1];
            for (int i = 0; i < orders.length; i++) {
                if (i == tableNumber) {
                    System.arraycopy(orders, 0, newTableOrder, 0, i);
                    System.arraycopy(orders, i + 1, newTableOrder, i, newTableOrder.length - i);
                }
            }
            orders = newTableOrder;
        }
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
