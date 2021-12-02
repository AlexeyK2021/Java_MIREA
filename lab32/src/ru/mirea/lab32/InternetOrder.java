package ru.mirea.lab32;

public class InternetOrder implements Order {
    private ListNode head, tail;
    private int size;
    private Customer customer;

    public InternetOrder() {
        head = tail = new ListNode();
        size = 0;
    }

    public InternetOrder(MenuItem[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++, size++) {
            add(arr[i]);
        }
    }

    @Override
    public boolean add(MenuItem AddingItem) {
        if (head.data == null) {
            head.data = AddingItem;
            return true;
        }
        tail.next = new ListNode(AddingItem);
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            if (node.data.getName().equals(itemName)) count++;
            node = node.next;
        }
        return count;
    }

    public int itemQuantity(MenuItem item) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            if (node.data.equals(item)) count++;
            node = node.next;
        }
        return count;
    }

    @Override
    public MenuItem[] getDishes() {
        MenuItem[] items = new MenuItem[0];
        ListNode node = head;
        while (node != null) {
            boolean found = false;
            for (MenuItem item : items) {
                if (item.equals(node.data)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                MenuItem[] tmp = new MenuItem[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = node.data;
                items = tmp;
            }
            node = node.next;
        }
        return items;
    }

    @Override
    public MenuItem[] getItemsWithoutRepeat() {
        MenuItem[] items = new MenuItem[0];
        ListNode node = head;
        int count = 0;
        while (node != null) {
            boolean found = false;
            for (MenuItem item : items) {
                if (item.equals(node.data)) {
                    found = true;
                    break;
                }
            }
            for (MenuItem i : items) if (i.getName().equals(node.data.getName())) count++;
            if (!found && count == 0) {
                MenuItem[] tmp = new MenuItem[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = node.data;
                items = tmp;
            }
            node = node.next;
            count = 0;
        }
        return items;
    }

    @Override
    public String[] dishesNames() {
        String[] res = new String[size];
        MenuItem[] uniqueItems = getDishes();
        for (int i = 0; i < uniqueItems.length; i++) {
            res[i] = uniqueItems[i].getName();
        }
        return res;
    }

    @Override
    public MenuItem[] sortedDishesByCost() {
        MenuItem[] items = getDishes();
        return BubbleSort(items);
    }

    @Override
    public boolean remove(String itemName) {
        ListNode node = head, prevNode = null;

        while (node != null) {
            if (node.data.getName().equals(itemName)) {
                if (prevNode != null) prevNode.next = node.next;
                if (node == tail) tail = prevNode;
                if (node == head) head = head.next;
                size--;
                return true;
            }
            prevNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (remove(itemName)) count++;
        return count;
    }

    @Override
    public int itemQuantity() {
        return size;
    }

    public boolean remove(MenuItem item) {
        ListNode node = head, prevNode = null;
        while (node != null) {
            if (node.data.equals(item)) {
                if (prevNode != null) prevNode.next = node.next;
                if (node == tail) tail = prevNode;
                if (node == head) head = head.next;
                size--;
                return true;
            }
            prevNode = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public double costTotal() {
        double cost = 0;
        ListNode node = head;
        while (node != null) {
            cost += node.data.getPrice();
            node = node.next;
        }
        return cost;
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

    public Customer getCostumer() {
        return customer;
    }

    public void setCostumer(Customer costumer) {
        this.customer = costumer;
    }
}
