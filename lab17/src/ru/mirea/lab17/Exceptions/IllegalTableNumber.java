package ru.mirea.lab17.Exceptions;

public class IllegalTableNumber extends Throwable{

    public IllegalTableNumber(String tableNUmber) {
        super("The table №" + tableNUmber + " doesn't exist!");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
