package ru.mirea.lab26;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        int i = 0;
        Scanner myScanner = new Scanner(System.in);
        while (i < 2) {
            System.out.print("Enter Key ");
            String key = myScanner.nextLine();
            try {
                printDetails(key);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                i++;
                continue;
            }
            break;
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}

