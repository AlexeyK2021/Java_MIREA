package ru.mirea.lab21;

public class TestNameable {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        Planet planet = new Planet("Earth");
        City city = new City("Moscow");

        System.out.println("Car is " + car.getName());
        System.out.println("Planet is " + planet.getName());
        System.out.println("City is " + city.getName());
        
    }
}
