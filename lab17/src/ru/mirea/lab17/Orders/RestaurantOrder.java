package ru.mirea.lab17.Orders;

import ru.mirea.lab17.Interfaces.Item;
import ru.mirea.lab17.Interfaces.Order;

public class RestaurantOrder implements Order {
    private Item[] items = new Item[0];

    RestaurantOrder() {
    }

    @Override
    public boolean add(Item AddingItem) {
        Item[] New = new Item[items.length + 1];
        if (items.length != 0) System.arraycopy(items, 0, New, 0, items.length);
        New[items.length] = AddingItem;
        items = New;
        return true;
    }

    public Item get(int index) {
        return items[index];
    }

    @Override
    public boolean remove(String itemName) {
        Item[] New = new Item[items.length - 1];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)) {
                System.arraycopy(items, 0, New, 0, i);
                System.arraycopy(items, i + 1, New, i, New.length - i);
            }
        }
        items = New;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        boolean isDeleted = false;
        while (!isDeleted) {
            isDeleted = true;
            Item[] New = new Item[items.length - 1];
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName)) {
                    System.arraycopy(items, 0, New, 0, i);
                    System.arraycopy(items, i + 1, New, i, New.length - i);
                    isDeleted = false;
                    count++;
                }
            }
            items = New;
        }
        return count;
    }

    @Override
    public int itemQuantity() {
        return items.length;
    }

    @Override
    public int itemQuantity(String dishName) {
        int quantity = 0;
        for (Item item : items)
            if (item.getName().equals(dishName))
                quantity++;
        return quantity;
    }

    @Override
    public Item[] getItemsWithoutRepeat() {
        Item[] NewItems = new Item[1];
        Item[] NewItems_;
        boolean isAlreadyInArray = false;
        for (Item i : items) {
            for (Item newItem : NewItems) {
                if (i.getName().equals(newItem.getName())) isAlreadyInArray = true;
            }
            if (!isAlreadyInArray) {
                NewItems_ = new Item[NewItems.length + 1];
                System.arraycopy(NewItems, 0, NewItems_, 0, NewItems.length);
                NewItems_[NewItems.length] = i;
                NewItems = NewItems_;
            }
        }
        return NewItems;
    }

    @Override
    public Item[] getDishes() {
        return items;
    }

    @Override
    public double costTotal() {
        double cost = 0;
        for (Item i : items)
            cost += i.getCost();
        return cost;
    }

    @Override
    public String[] dishesNames() {
        String[] names = new String[items.length];
        for (int i = 0; i < items.length; i++)
            names[i] = items[i].getName();
        return names;
    }

    @Override
    public Item[] sortedDishesByCost() {
        Item[] sorted = items;
        return BubbleSort(items);
    }

    private Item[] BubbleSort(Item[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[i].getCost() > array[j].getCost()) {
                    Item temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
