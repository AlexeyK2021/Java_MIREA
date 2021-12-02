package ru.mirea.lab32;

public class ListNode {
    public MenuItem data;
    public ListNode next;

    public ListNode(MenuItem data) {
        this.data = data;
    }

    public ListNode() {
        this(null);
    }
}
