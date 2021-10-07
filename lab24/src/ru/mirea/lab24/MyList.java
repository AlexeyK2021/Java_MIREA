package ru.mirea.lab24;

//public class MyList<T> {
//    private static final int DEFAULT_SIZE = 10;
//    private Object[] mylist;
//
//    public MyList(int initialSize) {
//        mylist = new Object[initialSize];
//    }
//
//    public MyList() {
//        mylist = new Object[DEFAULT_SIZE];
//    }
//
//    public T get(int index) {
//        return (T) mylist[index];
//    }
//
//    public int size() {
//        return mylist.length;
//    }
//
//    public boolean contains(Object o) {
//        for (int i = 0; i < size(); i++) {
//            if (mylist[i] == o) return true;
//        }
//        return false;
//    }
//
//    public void add(T element, int position) {
//        Object[] newList = new Object[mylist.length + 1];
//        int i = 0;
//        for (; i < position; i++) {
//            newList[i] = mylist[i];
//        }
//        i++;
//        newList[i] = element;
//        i++;
//        for (; i < mylist.length + 1; i++) {
//            newList[i] = mylist[i - 1];
//        }
//        mylist = newList;
//    }
//
//    public void add(T element) {
//        Object[] newList = new Object[mylist.length + 1];
//        int i = 0;
//        for (; i < mylist.length; i++) {
//            newList[i] = mylist[i];
//        }
//        newList[i] = element;
//        mylist = newList;
//    }
//
//    public void remove(int index) {
//        Object[] newList = new Object[mylist.length - 1];
//        int i = 0;
//        for (; i < index; i++) {
//            newList[i] = mylist[i];
//        }
//        i++;
//        for (; i < newList.length; i++) {
//            newList[i] = mylist[i];
//        }
//        mylist = newList;
//    }
//}

public class MyList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array;
    private int pointer = 0;
    public int size = INIT_SIZE;

    public MyList(int size) {
        this.size = size;
        array = new Object[size];
    }

    public MyList() {
        array = new Object[INIT_SIZE];
    }

    public void add(T item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        size--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);

    }

    public int Count() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}