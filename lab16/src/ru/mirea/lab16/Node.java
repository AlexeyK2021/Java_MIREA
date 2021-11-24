package ru.mirea.lab16;

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
