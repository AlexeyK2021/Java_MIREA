package ru.mirea.lab13;

public class TestFactory {
    public static void main(String[] args) {
        ConcreteFactory first = new ConcreteFactory();
        Complex firstNum = first.CreateComplex(10, 7);
        System.out.println(firstNum.getValue());
    }
}
