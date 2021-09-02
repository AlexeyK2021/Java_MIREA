package ru.mirea.lab2;

import java.lang.*;

public class TestAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Ivan Popov", "ivPopov@somewhere.com", 'M');
        Author a2 = new Author("Anna Ivanova", "anIvanova@somewhere.com", 'F');
        System.out.println(a1.toString());
        System.out.print(a2.toString());
    }
}
