package ru.mirea.lab16;

public class ListNode<E> {
    E data;
    ListNode<E> prev;
    ListNode<E> next;

    ListNode(E data) {
        this(null, data, null);
    }

    ListNode(ListNode<E> prev, E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


}
