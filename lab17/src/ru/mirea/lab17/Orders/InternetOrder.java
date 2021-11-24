package ru.mirea.lab17.Orders;

import ru.mirea.lab17.Classes.Node;
import ru.mirea.lab17.Interfaces.Item;
import ru.mirea.lab17.Interfaces.Order;

public class InternetOrder implements Order {
    private Node head, tail;
    private int size;

    public InternetOrder() {
        head = tail = new Node();
        size = 0;
    }

    public InternetOrder(Item[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++, size++) {
            add(arr[i]);
        }
    }

    @Override
    public boolean add(Item AddingItem) {
        if (head.data == null) {
            head.data = AddingItem;
            return true;
        }
        tail.next = new Node(AddingItem);
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        Node node = head;
        while (node != null) {
            if (node.data.getName().equals(itemName)) count++;
            node = node.next;
        }
        return count;
    }

    public int itemQuantity(Item item) {
        int count = 0;
        Node node = head;
        while (node != null) {
            if (node.data.equals(item)) count++;
            node = node.next;
        }
        return count;
    }

    @Override
    public Item[] getDishes() {
        Item[] items = new Item[0];
        Node node = head;
        while (node != null) {
            boolean found = false;
            for (Item item : items) {
                if (item.equals(node.data)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Item[] tmp = new Item[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = node.data;
                items = tmp;
            }
            node = node.next;
        }
        return items;
    }

    @Override
    public Item[] getItemsWithoutRepeat() {
        Item[] items = new Item[0];
        Node node = head;
        int count = 0;
        while (node != null) {
            boolean found = false;
            for (Item item : items) {
                if (item.equals(node.data)) {
                    found = true;
                    break;
                }
            }
            for (Item i : items) if (i.getName().equals(node.data.getName())) count++;
            if (!found && count == 0) {
                Item[] tmp = new Item[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = node.data;
                items = tmp;
            }
            node = node.next;
            count = 0;
        }
        return items;
    }

    @Override
    public String[] dishesNames() {
        String[] res = new String[size];
        Item[] uniqueItems = getDishes();
        for (int i = 0; i < uniqueItems.length; i++) {
            res[i] = uniqueItems[i].getName();
        }
        return res;
    }

    @Override
    public Item[] sortedDishesByCost() {
        Item[] items = getDishes();
        return BubbleSort(items);
    }

    @Override
    public boolean remove(String itemName) {
        Node node = head, prevNode = null;

        while (node != null) {
            if (node.data.getName().equals(itemName)) {
                if (prevNode != null) prevNode.next = node.next;
                if (node == tail) tail = prevNode;
                if (node == head) head = head.next;
                size--;
                return true;
            }
            prevNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (remove(itemName)) count++;
        return count;
    }

    @Override
    public int itemQuantity() {
        return size;
    }

    public boolean remove(Item item) {
        Node node = head, prevNode = null;
        while (node != null) {
            if (node.data.equals(item)) {
                if (prevNode != null) prevNode.next = node.next;
                if (node == tail) tail = prevNode;
                if (node == head) head = head.next;
                size--;
                return true;
            }
            prevNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public double costTotal() {
        double cost = 0;
        Node node = head;
        while (node != null) {
            cost += node.data.getCost();
            node = node.next;
        }
        return cost;
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
