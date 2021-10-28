package ru.mirea.lab8;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test BoundedWaitList");
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<>(5);
        for (int i = 1; i < 6; i++) boundedWaitList.add(i);
        System.out.println("Initial capacity = " +boundedWaitList.getCapacity());
        boundedWaitList.remove();
        System.out.println("Capacity after removing: " +boundedWaitList.getCapacity());
        System.out.println("Contains 1 ? " + boundedWaitList.contains(1));

        System.out.println("\nTest UnfairWaitList");
        UnfairWaitList<Integer> unfairWaitList = new UnfairWaitList<>();
        for (int i = 1; i < 6; i++) unfairWaitList.add(i);
        System.out.println("Contains 2 ? " + unfairWaitList.contains(2));
        unfairWaitList.remove(2);
        System.out.println("Contains 2 ? " + unfairWaitList.contains(2));
    }
}
