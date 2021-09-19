package ru.mirea.lab3;

public class MovableRectangle {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1,int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1,y1,xSpeed,ySpeed);
        bottomRight = new MovablePoint(x2,y2,xSpeed,ySpeed);

    }

    @Override
    public String toString() {
        return "MovableCircle{ " +
                "topLeft=(" + topLeft.x + " ; " + topLeft.y + ")" +
                ", bottomRight=(" + bottomRight.x + " ; " + bottomRight.y + ")}";
    }

    public void moveUp() {
        bottomRight.moveUp();
        topLeft.moveUp();
    }

    public void moveDown() {
        bottomRight.moveDown();
        topLeft.moveDown();
    }

    public void moveLeft() {
        bottomRight.moveLeft();
        topLeft.moveLeft();
    }

    public void moveRight() {
        bottomRight.moveRight();
        topLeft.moveRight();
    }
}
