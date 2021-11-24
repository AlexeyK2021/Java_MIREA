package ru.mirea.lab16;

public class TestInternetOrder {
    public static void main(String[] args) {
        InternetOrder internetOrder = new InternetOrder();

        internetOrder.add(new Drink(1500, "Cognac", "Cognac from France"));
        internetOrder.add(new Dish(1500, "Salad", "Salad with shrimps"));
        internetOrder.add(new Dish(2000, "Olivier", "Olivier with chicken"));
        internetOrder.add(new Dish(1500, "Salad", "Salad with shrimps"));
        internetOrder.add(new Dish(1500, "Wine", "Wine from 1976"));

        System.out.println("Order: \nName\t\tPrice\t\tDescription");
        int count = 0;
        for (Item i : internetOrder.getItems()) {
            System.out.println(i.getName() + "\t\t" + i.getCost() + "\t\t" + i.getDescription());
            count++;
        }
        System.out.println("Total: " + count + " items on " + internetOrder.costTotal());

    }
}
