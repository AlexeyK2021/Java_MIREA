package lab5_12;

import java.lang.*;
import java.util.Scanner;

public class main {
    public static void counter() {
        Scanner scan = new Scanner(System.in);
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
