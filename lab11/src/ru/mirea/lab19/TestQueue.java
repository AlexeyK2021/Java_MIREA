package ru.mirea.lab19;

public class TestQueue {
    public static void main(String[] args) {
        ArrayQueueModule arrayQueueModule = ArrayQueueModule.getInstance();
        arrayQueueModule.enqueue(156);
        arrayQueueModule.enqueue("Hello World!");
        arrayQueueModule.enqueue(746.7d);

        System.out.println("Elements in ArrayQueueModule:");
        while (!arrayQueueModule.isEmpty()) System.out.println(arrayQueueModule.dequeue());

        try {
            ArrayQueue arrayQueue = new ArrayQueue();
            arrayQueue.dequeue();
        } catch (Exception e) {
            System.out.println("Exception from ArrayQueue: " + e.getMessage());
        }

        ArrayQueueModule arrayQueueModule1 = ArrayQueueModule.getInstance();
        arrayQueueModule1.enqueue(186);
        arrayQueueModule1.enqueue("Qwerty12345");
        arrayQueueModule1.enqueue(28.11);

        try {
            ArrayQueueADT arrayQueueADT = new ArrayQueueADT(arrayQueueModule1);
            arrayQueueADT.dequeue();
        } catch (Exception e) {
            System.out.println("Exception from ArrayQueueADT: " + e.getMessage());
        }

    }
}
