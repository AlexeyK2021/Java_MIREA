package ru.mirea.lab27;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(10,0);
        list.add(31,1);
        list.add(112,2);
        list.add(17,3);
        list.add(154,4);
        for (int i = 0;i<list.getSize();i++) {
            System.out.println(list.get(i)+" ");
        }
    }
}
