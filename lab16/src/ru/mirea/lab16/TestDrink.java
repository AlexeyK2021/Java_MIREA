package ru.mirea.lab16;

public class TestDrink {
    public static void main(String[] args) {
        Drink drink = new Drink(1500, "Wine", "Red wine 1950s");
        System.out.println(drink.getName() + " costs " + drink.getCost() + " and have a discription: " + drink.getDescription());
    }
}
