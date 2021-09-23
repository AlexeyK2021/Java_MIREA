package ru.mirea.lab20;

import java.util.ArrayList;

public class FurnitureShop {
    private static ArrayList<Furniture> furnitures = new ArrayList<Furniture>();

    public static void main(String[] args) {

        furnitures.add(new Chair("Дерево", 500, "Чёрный"));
        furnitures.add(new Wardrobe("Дерево", 2500, "Бежевый"));
        furnitures.add(new Table("Стекло", 4500, "Прозрачный"));
        furnitures.add(new Sofa("Искусственная кожа", 5000, "Янтарный"));
        printAssortment();
    }

    private static void printAssortment() {
        for (int i = 0; i < furnitures.toArray().length; i++) {
            System.out.println(furnitures.toArray()[i].toString());
        }
    }
}
