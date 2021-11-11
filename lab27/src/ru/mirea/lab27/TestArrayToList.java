package ru.mirea.lab27;

import java.util.List;

public class TestArrayToList {
    public static void main(String[] args) {
        ArrayToList<Integer> converter = new ArrayToList<Integer>();
        Integer[] list = new Integer[]{10,12,35,78,211,334};

        List list1 = converter.convert(list);
        for (Object o:list1) {
            System.out.print(o+" ");
        }
    }
}
