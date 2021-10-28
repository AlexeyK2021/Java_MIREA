package ru.mirea.lab8;

public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {
    }

    /**
     * Removing element from the queue using the cyclical comparing
     * @param element
     */
    public void remove(E element) {
        ;
        for (int i = 0; i < super.content.size(); i++) {
            if (super.content.getFirst() != element) {
                super.content.add(super.content.getFirst());
            }
            super.content.remove();
        }
    }
    /**
     * Moving element to the end of queue using the cyclical comparing
     * @param element
     */
    public void moveToBack(E element) {
        for (int i = 0; i < super.content.size(); i++) {
            if (super.content.getFirst() == element) {
                super.content.add(super.content.getFirst());
            }
            super.content.remove();
        }
    }
}
