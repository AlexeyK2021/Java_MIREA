package ru.mirea.lab27;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] list;
    private int count;
    private int size;

    public MyArrayList() {
        size = 8;
        list = (T[]) new Object[size];
    }

    public MyArrayList(int size) {
        this.size = size;
        list = (T[]) new Object[size];
        count = 0;
    }

    public void add(T o, int index) {
        if (size - count == 1) resize(size * 2);
        System.arraycopy(list, index, list, index + 1, count - index);
        list[index] = o;
    }

    public int indexOf(T o) {
        for (int i = 0; i < count; i++)
            if (list[i].equals(o)) return i;
        return -1;
    }

    public T remove(int index) {
        if (index > count)
            throw new IndexOutOfBoundsException();
        T o = list[index];
        System.arraycopy(list, index + 1, list, index, count - index - 1);
        list[--count] = null;

        if (count < size / 2) resize(size / 2);
        return o;
    }

    private void resize(int nSize) {
        if (nSize > size)
            list = Arrays.copyOf(list, nSize);
        else {
            T[] tmp = (T[]) new Object[nSize];
            System.arraycopy(list, 0, tmp, 0, nSize);
            list = tmp;
        }
        size = nSize;

    }

    public T get(int index) {
        if (index > count)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return size;
    }
}
