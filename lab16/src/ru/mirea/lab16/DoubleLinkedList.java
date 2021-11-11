package ru.mirea.lab16;

public class DoubleLinkedList<E> {
    private ListNode<E> front;

    private int size;

    public DoubleLinkedList() {
        front = null;
    }

    public void addFront(E x) {
        if (isEmpty())
            front = new ListNode<E>(x);
        else {
            ListNode<E> temp = front;
            front = new ListNode<E>(null, x, temp);
            front.next.prev = front;
        }
        size++;
    }

    public void addEnd(E x) {
        if (isEmpty())
            front = new ListNode<E>(x);
        else {
            ListNode<E> temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode<E>(temp, x, null);
        }
        size++;
    }

    public boolean remove(E x) {
        if (front.data.equals(x)) {
            front = front.next;
            return true;
        }
        else return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
