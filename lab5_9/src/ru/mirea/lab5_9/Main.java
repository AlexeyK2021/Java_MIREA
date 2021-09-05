package ru.mirea.lab5_9;

import java.lang.*;
import java.util.Scanner;

public class Main {
    public static int counter(int a, int b) {
        if (a - b > 1) return 0;
        if (a == 0 || b == 0) return 1;
        return counter(a, b - 1) + counter(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(counter(a, b));
    }
}
