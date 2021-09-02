package ru.mirea.lab1;

import java.lang.*;

public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("Война и мир", "Лев Толстой", 1696);
        Book b2 = new Book("Мертвые души", "Николай Гоголь", 355);
        Book b3 = new Book("Евгений Онегин");
        b3.setAuthor("Александр Пушкин");
        b3.setPages(448);
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.print(b3.toString());
    }
}
