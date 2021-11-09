package ru.mirea.lab16;

public class Order {
    private Item[] items = new Item[0];

    public void add(Item AddingItem) {
        Item[] New = new Item[items.length + 1];
        if (items.length != 0) System.arraycopy(items, 0, New, 0, items.length);
        New[items.length + 1] = AddingItem;
        items = New;
    }

    public Item get(int index) {
        return items[index];
    }

    public void remove(String itemName) {
        Item[] New = new Item[items.length - 1];
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(itemName)) {
                System.arraycopy(items, 0, New, 0, i);
                System.arraycopy(items, i + 1, New, 0, items.length);
            }
        }
    }

    public int dishQuantity() {
        return items.length;
    }

    public int dishQuantity(String dishName) {
        int quantity = 0;
        for (Item item : items)
            if (item.getName().equals(dishName))
                quantity++;
        return quantity;
    }

    public Item[] getDishes() {
        return items;
    }

    public double costTotal() {
        double cost = 0;
        for (Item i : items)
            cost += i.getCost();
        return cost;
    }

    public String[] dishesNames() {
        String[] names = new String[items.length];
        for (int i = 0; i < items.length; i++)
            names[i] = items[i].getName();
        return names;
    }

    public Item[] sortedDishesByCostDesc() {
        Item[] sorted = items;
        return BubbleSort(items);
    }

    private Item[] BubbleSort(Item[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[i].getCost() > array[j].getCost()) {
                    Item temp = array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
    }
}
