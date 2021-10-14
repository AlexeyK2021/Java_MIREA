package ru.mirea.lab12;

public class Main {
    public static void main(String[] args) {
        PhoneNumber num = new PhoneNumber();
        System.out.println(num.ConvertNumber("81234567890"));
        System.out.println(num.ConvertNumber("+901234567890"));
    }
}
