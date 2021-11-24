package ru.mirea.lab29;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern p = Pattern.compile("[0-9] \\+");

        System.out.println("Enter the expression:");
        String expr = scan.nextLine();

        Matcher m = p.matcher(expr);
        System.out.println("Result is " + m.find());
    }
}
