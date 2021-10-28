package ru.mirea.lab8;

public class BoundedWaitList<E> extends WaitList<E> {
    private final int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Object element) {
        if (super.content.size() < capacity)
            super.add(element);
        else {
            System.out.println("Can't add element (" + element + ") to BoundedWaitList!");
        }
    }

    @Override
    public String toString() {
        return "BoundedWaitList:" +
                " capacity=" + capacity;
    }
}
