package ru.mirea.lab17;

public class OrderAlreadyAddedException extends Throwable {
    private String message;
    public OrderAlreadyAddedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
