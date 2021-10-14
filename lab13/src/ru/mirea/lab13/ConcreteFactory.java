package ru.mirea.lab13;

public class ConcreteFactory implements ComplexAbstractFactory {
    ConcreteFactory() {
    }

    @Override
    public Complex createComplex() {
        return new Complex();
    }

    @Override
    public Complex CreateComplex(int real, int image) {
        return new Complex(real + "+" + image + "i");
    }

    public String getValue(Complex number) {
        return number.getValue();
    }
}
