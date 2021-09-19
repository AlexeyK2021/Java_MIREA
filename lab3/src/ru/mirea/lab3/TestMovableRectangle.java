package ru.mirea.lab3;

public class TestMovableRectangle {
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(0,3,5,0,1,1);
        System.out.println(rectangle.toString());
        rectangle.moveDown();
        rectangle.moveLeft();
        rectangle.moveDown();
        rectangle.moveLeft();
        System.out.println(rectangle.toString());
    }
}
