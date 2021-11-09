package ru.mirea.lab19;


public class ArrayQueue<E> {
    private final int INIT_SIZE = 16;
    private Object[] elements;

    public ArrayQueue(int size) {
        elements = new Object[size];
    }

    public ArrayQueue() {
        elements = new Object[INIT_SIZE];
    }

    public void enqueue(E elem) {
        Object[] NewQueue = new Object[elements.length + 1];
        NewQueue[0] = elem;

        for (int i = 0; i < NewQueue.length; i++) {
            NewQueue[i + 1] = elements[i];
        }
        elements = NewQueue;
    }

    public E element() {
        return (E) elements[0];
    }

    public E dequeue() {
        Object elem = elements[0];

        Object[] NewQueue = new Object[elements.length - 1];
        for (int i = 0; i < NewQueue.length; i++) {
            NewQueue[i] = elements[i + 1];
        }

        elements = NewQueue;
        return (E) elem;
    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public void Clear() {
        elements = new Object[0];
    }
}
