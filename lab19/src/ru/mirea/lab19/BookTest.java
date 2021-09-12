package ru.mirea.lab19;

public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book("Мертвые души", "Николай Гоголь", 1841, 352);
        Book book2 = new Book("Война и мир");
        book2.setAuthorName("Лев Толстой");
        book2.setWritingYear(1869);
        book2.setPages(1827);
        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }
}
