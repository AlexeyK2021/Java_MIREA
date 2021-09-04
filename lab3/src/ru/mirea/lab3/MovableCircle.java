package ru.mirea.lab3;

public class MovableCircle extends MovablePoint {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        super(x, y, xSpeed, ySpeed);
        this.radius = radius;
        center = new MovablePoint(this.x, this.y, this.xSpeed, this.ySpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle: " +
                "radius=" + radius +
                ", center=(" + center.x + " ; " + center.y + ")";
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
}
