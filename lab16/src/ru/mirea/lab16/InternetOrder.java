package ru.mirea.lab16;

public class InternetOrder {
    private DoubleLinkedList<Item> items;

    InternetOrder(){
        items = new DoubleLinkedList<>();
    }
    InternetOrder(Order order){
        for (Item i: order.getDishes()){
            items.addFront(i);
        }
    }
    public void add(Item item){
        items.addFront(item);
    }
    public boolean remove(String dishName){
        for

        return false;
    }
    
}
