package ru.mirea.lab14;

public class Client {
    Chair chair;

    public void sit() {
        System.out.println("I'm siiting on " + chair.getClass().getSimpleName());
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
