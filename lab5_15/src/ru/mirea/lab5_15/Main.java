package ru.mirea.lab5_15;

import java.util.Scanner;

public class Main {
    public static int reverse(int n) {
        if (n < 10) {
            return n;
        } else {
            System.out.print(n % 10 + " ");
            return reverse(n / 10);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(reverse(scan.nextInt()));
    }
}
