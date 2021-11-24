package ru.mirea.lab16;

public class TestTablesOrderManager {
    public static void main(String[] args) {
        TablesOrderManager main = new TablesOrderManager();
        Order first = new Order();
        first.add(new Drink(1500, "Wine", "Red wine 1950s"));
        first.add(new Dish(2000, "Salad", "Salad with shrimps"));
        main.add(first, 5);
        Order second = new Order();
        second.add(new Drink(1000, "Сhampagne", "Champagne from France"));
        second.add(new Dish(2000, "Salad", "Salad with shrimps"));
        main.add(second, 2);

        System.out.println("Summary are " + main.dishQuantity("Salad") + " Salads!");

        for (Order o : main.getOrders()) {
            System.out.println("Order:");
            for (Item i : o.getDishes()) {
                System.out.println(i.getName() + " " + i.getCost());
            }
            System.out.println();
        }
    }
}
