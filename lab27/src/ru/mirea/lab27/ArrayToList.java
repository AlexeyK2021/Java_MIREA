package ru.mirea.lab27;

import java.util.ArrayList;

public class ArrayToList<E> {
    public ArrayToList() {
    }

    public ArrayList<E> convert(Object[] array) {
        ArrayList<E> list = new ArrayList<E>();
        for (Object o : array) {
            list.add((E) o);
        }
        return list;
    }
}
