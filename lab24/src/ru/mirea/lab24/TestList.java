package ru.mirea.lab24;

import java.util.Random;

public class TestList {
    public static void main(String[] args) {
        MyList<Integer> my1 = new MyList<Integer>(10);
        for (int i = 0; i < my1.size; i++) {
            int number = (int) (Math.random() * 100);
            my1.add(number);
            System.out.print(number+"\t");
        }
        System.out.println();
        printArray(my1);
        printArray(my1);
        my1.remove(2);
        my1.remove(2);
        printArray(my1);

    }

    public static void printArray(MyList<Integer> array) {
        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.println();
    }
}
