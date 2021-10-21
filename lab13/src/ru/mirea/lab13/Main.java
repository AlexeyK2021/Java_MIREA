package ru.mirea.lab13;

public class Main {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        Complex first = factory.createComplex();
        Complex second = factory.CreateComplex(10, -4);
        Complex third = factory.CreateComplex(15, 5);
        System.out.println(
                "First complex number is " + first.getValue() +
                        "\nSecond is " + second.getValue() +
                        "\nTrird is " + third.getValue()
        );
    }
}
