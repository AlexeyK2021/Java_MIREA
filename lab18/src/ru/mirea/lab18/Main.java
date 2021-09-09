package ru.mirea.lab18;


public class Main {
    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubbleSort(arr);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
