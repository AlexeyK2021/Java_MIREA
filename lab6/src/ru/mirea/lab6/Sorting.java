package ru.mirea.lab6;

public class Sorting {

    public static Comparable[] mergeSort(Comparable[] list) {
        if (list == null) {
            return null;
        } else if (list.length == 1) {
            return list;
        }
        Comparable[] list2 = new Comparable[list.length / 2];
        System.arraycopy(list, 0, list2, 0, list.length / 2);

        Comparable[] list3 = new Comparable[list.length/2];
        System.arraycopy(list, list.length / 2, list3, 0, list.length - list.length / 2);
        list2 = mergeSort(list2);
        list3 = mergeSort(list3);

        return (list2,list3);
    }
    public int [] mergeArray(Comparable[] arrayА, Comparable[] arrayB) {

        Comparable [] arrayC = new Comparable[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayА.length){
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[i - positionA];
                positionA++;
            } else if (arrayА[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayА[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
}
