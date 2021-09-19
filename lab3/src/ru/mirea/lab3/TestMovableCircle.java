package ru.mirea.lab3;
import java.lang.*;

public class TestMovableCircle {
    public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(3,5,1,1,5);
        System.out.println(circle.toString());
        circle.moveDown();
        circle.moveLeft();
        circle.moveDown();
        circle.moveLeft();
        System.out.println(circle.toString());
    }
}
