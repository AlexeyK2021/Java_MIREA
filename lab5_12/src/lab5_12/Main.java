package lab5_12;

import java.lang.*;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void counter() {
        int a = scan.nextInt();
        if (a > 0) {
            if (a % 2 == 1) {
                System.out.println(a);
                counter();
            } else {
                counter();
            }
        }
    }

    public static void main(String[] args) {
        counter();
    }
}
