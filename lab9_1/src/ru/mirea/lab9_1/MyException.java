package ru.mirea.lab9_1;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
