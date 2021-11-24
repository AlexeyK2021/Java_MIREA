package ru.mirea.lab30;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern p = Pattern.compile("\\w+@\\w+");
        System.out.println("Enter your Email:");
        Matcher m = p.matcher(scan.nextLine());
        System.out.println("Your email " + (m.find() ? "is" : "isn't") + " correct!");
    }
}
