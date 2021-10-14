package ru.mirea.lab9_2;

public class CantFindStudentException extends Throwable {
    public String message;
    CantFindStudentException(String message){
        this.message = message;
    }
}
