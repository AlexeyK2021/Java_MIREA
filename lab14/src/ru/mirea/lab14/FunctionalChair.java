package ru.mirea.lab14;

public class FunctionalChair implements Chair {
    public String sum(int a, int b) {
        int sum = a + b;
        return a + "+" + b + "=" + sum;
    }
}
