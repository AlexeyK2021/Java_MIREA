package ru.mirea.lab31;

public class TestOrdersManagers {
    public static void main(String[] args) {
        InternetOrder internetOrder = new InternetOrder();

        internetOrder.add(new Drink(1500, "Vodka", "Vodka 40%", DrinkTypeEnum.VODKA));
        internetOrder.add(new Dish(1500, "Salad", "Salad with shrimps"));
        internetOrder.add(new Dish(2000, "Olivier", "Olivier with chicken"));
        internetOrder.add(new Drink(1500, "Wine", "Wine from 1976", DrinkTypeEnum.WINE));
        internetOrder.setCostumer(new Customer("Alexey", "Kalashnikov", 18, new Address("Moscow", 117463, "Karamzina", 50, 'a', 100)));

        InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
        try {
            internetOrdersManager.add("2", internetOrder);
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        TableOrder tableOrder = new TableOrder();
        tableOrder.add(new Drink(1500, "Whiskey", "Best type of alcohol", DrinkTypeEnum.WHISKEY));
        tableOrder.add(new Dish(1500, "Salad", "Salad with shrimps"));
        tableOrder.add(new Dish(2000, "Olivier", "Olivier with chicken"));
        tableOrder.setCostumer(new Customer("Noname", "Noname", 27, new Address()));
        TablesOrdersManager tablesOrdersManager = new TablesOrdersManager();
        try {
            tablesOrdersManager.add(tableOrder, 5);
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Restaurant Order: \nName\t\tPrice\t\tDescription");
        int count = 0;
        try {
            Order orders = tablesOrdersManager.getOrder(5);
            for (int i = 0; i < orders.itemQuantity(); i++) {
                MenuItem item = orders.getDishes()[i];
                System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getDescription());
                count++;
            }
            System.out.println("Total: " + count + " items on " + internetOrder.costTotal());
        } catch (IllegalTableNumber e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");
        System.out.println("Internet Order: \nName\t\tPrice\t\tDescription");
        int count_ = 0;
        Order[] orders = internetOrdersManager.getOrders();
        for (Order o : orders) {
            for (int i = 0; i < o.itemQuantity(); i++) {
                MenuItem item = o.getDishes()[i];
                System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getDescription());
                count_++;
            }
        }
        System.out.println("Total: " + count_ + " items on " + internetOrder.costTotal());

    }
}

