package ru.mirea.lab31;

public class TableOrder implements Order {
    private MenuItem[] items = new MenuItem[0];
    private  Customer customer;
    TableOrder() {
    }

    @Override
    public boolean add(MenuItem AddingItem) {
        MenuItem[] New = new MenuItem[items.length + 1];
        if (items.length != 0) System.arraycopy(items, 0, New, 0, items.length);
        New[items.length] = AddingItem;
        items = New;
        return true;
    }

    public MenuItem get(int index) {
        return items[index];
    }

    @Override
    public boolean remove(String itemName) {
        MenuItem[] New = new MenuItem[items.length - 1];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)) {
                System.arraycopy(items, 0, New, 0, i);
                System.arraycopy(items, i + 1, New, i, New.length - i);
            }
        }
        items = New;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        boolean isDeleted = false;
        while (!isDeleted) {
            isDeleted = true;
            MenuItem[] New = new MenuItem[items.length - 1];
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName)) {
                    System.arraycopy(items, 0, New, 0, i);
                    System.arraycopy(items, i + 1, New, i, New.length - i);
                    isDeleted = false;
                    count++;
                }
            }
            items = New;
        }
        return count;
    }

    @Override
    public int itemQuantity() {
        return items.length;
    }

    @Override
    public int itemQuantity(String dishName) {
        int quantity = 0;
        for (MenuItem item : items)
            if (item.getName().equals(dishName))
                quantity++;
        return quantity;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int quantity = 0;
        for (MenuItem i : items)
            if (item.equals(i))
                quantity++;
        return quantity;
    }

    @Override
    public MenuItem[] getItemsWithoutRepeat() {
        MenuItem[] NewItems = new MenuItem[1];
        MenuItem[] NewItems_;
        boolean isAlreadyInArray = false;
        for (MenuItem i : items) {
            for (MenuItem newItem : NewItems) {
                if (i.getName().equals(newItem.getName())) isAlreadyInArray = true;
            }
            if (!isAlreadyInArray) {
                NewItems_ = new MenuItem[NewItems.length + 1];
                System.arraycopy(NewItems, 0, NewItems_, 0, NewItems.length);
                NewItems_[NewItems.length] = i;
                NewItems = NewItems_;
            }
        }
        return NewItems;
    }

    @Override
    public MenuItem[] getDishes() {
        return items;
    }

    @Override
    public double costTotal() {
        double cost = 0;
        for (MenuItem i : items)
            cost += i.getPrice();
        return cost;
    }

    @Override
    public String[] dishesNames() {
        String[] names = new String[items.length];
        for (int i = 0; i < items.length; i++)
            names[i] = items[i].getName();
        return names;
    }

    @Override
    public MenuItem[] sortedDishesByCost() {
        MenuItem[] sorted = items;
        return BubbleSort(items);
    }

    private MenuItem[] BubbleSort(MenuItem[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[i].getPrice() > array[j].getPrice()) {
                    MenuItem temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
    public Customer getCostumer(){
      return customer;
    }
    public void setCostumer(Customer costumer){
      this.customer = costumer;
    }

}
