package ru.mirea.lab27;

import java.util.ArrayList;

public class ArrayToList {
    public ArrayList<Object> convert(Object[] array) {
        ArrayList<Object> list = new ArrayList<>();
        for (Object o : array) {
            list.add(o);
        }
        return list;
    }
}
