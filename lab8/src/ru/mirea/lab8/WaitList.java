package ru.mirea.lab8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;

public class WaitList<E> implements IWaitList {
    protected ConcurrentLinkedDeque<E> content;

    public WaitList() {
        content = new ConcurrentLinkedDeque<>();
    }

    public WaitList(Collection<E> c) {
        content = new ConcurrentLinkedDeque<>(c);
    }

    @Override
    public String toString() {
        return "size = " + content.size();
    }

    @Override
    public void add(Object element) {
        content.add((E) element);
    }

    @Override
    public E remove() {
        return content.remove();
    }

    @Override
    public boolean contains(Object element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.size() > 0;
    }
}
