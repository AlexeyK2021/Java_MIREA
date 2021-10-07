package ru.mirea.lab9_1;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Purchase();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Purchase() throws MyException {
        String FullName;
        String INN;

        System.out.println("Введите своё имя, фамилию и отчество");
        FullName = scan.nextLine();

        System.out.println("Введите свой ИНН");
        INN = scan.nextLine();

        if (INN.length() != 12 || Long.parseLong(INN) < 99999999999L)
            throw new MyException("Ошибка проверки ИНН. Несуществующий ИНН");
        else System.out.println("Покупка успешна!");

    }
}
