package ru.mirea.lab19;

public class ArrayQueueModule {
    private int size;
    private Object[] elements = new Object[5];

    public void enqueue(Object element) {
        editCapacity(size + 1);
        elements[++size] = element;
    }

    private void editCapacity(int capacity) {
        Object[] NewQueue = new Object[capacity];
        if (capacity > elements.length) {
            System.arraycopy(elements, 0, NewQueue, 0, elements.length);
        } else if (capacity < elements.length) {
            System.arraycopy(elements, 1, NewQueue, 0, elements.length - 1);
        }
        elements = NewQueue;
    }

    public Object element() {
        return elements[0];
    }

    public Object dequeue() {
        Object elem = elements[0];
        editCapacity(size - 1);
        return elem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void Clear() {
        elements = new Object[0];
    }
}
