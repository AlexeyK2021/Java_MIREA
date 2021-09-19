package ru.mirea.lab3;
import java.lang.*;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide(){
        return super.length;
    }
    public void setSide(double side){
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Square{" +
                "width = " + width +
                ", length = " + length +
                ", area = " + getArea() +
                ", perimeter = " + getPerimeter() +
                ", color = " + color +
                ", filled = " + filled+" }";
    }
}
