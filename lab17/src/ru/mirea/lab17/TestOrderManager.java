package ru.mirea.lab17;

public class TestOrderManager {
    public static void main(String[] args) {
        InternetOrder internetOrder = new InternetOrder();

        internetOrder.add(new Drink(1500, "Cognac", "Cognac from France"));
        internetOrder.add(new Dish(1500, "Salad", "Salad with shrimps"));
        internetOrder.add(new Dish(2000, "Olivier", "Olivier with chicken"));
        internetOrder.add(new Dish(1500, "Wine", "Wine from 1976"));

        OrderManager first = new OrderManager();
        try {
            first.add("10", internetOrder);
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
        RestaurantOrder restaurantOrder = new RestaurantOrder();
        restaurantOrder.add(new Drink(1500, "Cognac", "Cognac from France"));
        restaurantOrder.add(new Dish(1500, "Salad", "Salad with shrimps"));
        restaurantOrder.add(new Dish(2000, "Olivier", "Olivier with chicken"));
        try {
            first.add(restaurantOrder, 2);
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Restaurant Order: \nName\t\tPrice\t\tDescription");
        int count = 0;
        try {
            Order orders = first.getOrder(2);
            for (int i = 0; i < orders.itemQuantity(); i++) {
                Item item = orders.getDishes()[i];
                System.out.println(item.getName() + "\t\t" + item.getCost() + "\t\t" + item.getDescription());
                count++;
            }
            System.out.println("Total: " + count + " items on " + internetOrder.costTotal());
        } catch (IllegalTableNumber e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");
        System.out.println("Internet Order: \nName\t\tPrice\t\tDescription");
        int count_ = 0;
        Order[] orders = first.getInternetOrders();
        for (Order o : orders) {
            for (int i = 0; i < o.itemQuantity(); i++) {
                Item item = o.getDishes()[i];
                System.out.println(item.getName() + "\t\t" + item.getCost() + "\t\t" + item.getDescription());
                count_++;
            }
        }
        System.out.println("Total: " + count_ + " items on " + internetOrder.costTotal());

    }
}

