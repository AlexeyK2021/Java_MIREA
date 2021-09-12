package ru.mirea.lab19;

import java.lang.*;

public class Book {
    private String bookName;
    private String authorName;
    private int writingYear;
    private int pages;


    public Book(String bookName, String authorName, int writingYear, int pages) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pages = pages;
        this.writingYear = writingYear;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getWritingYear() {
        return writingYear;
    }

    public void setWritingYear(int writingYear) {
        this.writingYear = writingYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        return "Книга: " + bookName + "; Автор: " + authorName + "; Год написания: " + writingYear + "; Страниц: " + pages;
    }
}
