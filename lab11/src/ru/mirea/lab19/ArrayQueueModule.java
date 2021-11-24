package ru.mirea.lab19;

public class ArrayQueueModule {
    private Object[] elements;
    private static ArrayQueueModule instance;
    protected int head, tail;
    protected final int START_CAPACITY = 16;

    public ArrayQueueModule() {
        elements = new Object[START_CAPACITY];
        head = tail = 0;
    }

    public static ArrayQueueModule getInstance() {
        if (instance == null) instance = new ArrayQueueModule();
        return instance;
    }

    public Object dequeue() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException("Queue is EMPTY!");
        Object temp = elements[head++];
        if (head == elements.length) head = 0;
        if (Math.abs(head - tail) < (elements.length / 2)) resize(elements.length / 2);
        return temp;
    }

    public void enqueue(Object element) {
        elements[tail++] = element;
        if (elements.length == tail) tail = 0;
        if (head == tail) resize(elements.length / 2);
    }

    private void resize(int newSize) {
        Object[] newQueue = new Object[newSize];
        int q = Math.abs(head - tail);
        System.arraycopy(elements, head, newQueue, 0, q);
        tail = q;
        head = 0;
        elements = newQueue;
    }

    public Object element() {
        if (isEmpty()) throw new IndexOutOfBoundsException("Queue is EMPTY!");
        return elements[head];
    }

    public boolean clear() {
        boolean isEmpty = isEmpty();
        head = tail =0;
        resize(START_CAPACITY);
        return !isEmpty;
    }

    public boolean isEmpty() {
        return head == tail;
    }
}
