package ru.mirea.lab17.Classes;

import ru.mirea.lab17.Interfaces.Item;

public class Node {
    public Item data;
    public Node next;

    public Node(Item data) {
        this.data = data;
    }

    public Node() {
        this(null);
    }
}
