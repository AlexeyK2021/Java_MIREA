package ru.mirea.lab25;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileWriter writer;
        Scanner scan = new Scanner(System.in);
        System.out.println("Write something to save");

        try {
            writer = new FileWriter("src/ru/mirea/lab25/Text.txt",true);
            boolean isWork = true;
            while (isWork) {
                String text = scan.nextLine();
                if (text.equals(":q")) isWork = false;
                else {
                    writer.write(text+"\n");
                    writer.flush();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
