package ru.mirea.lab27;

import java.util.ArrayList;

public class AnyList{
    private ArrayList<Object> list = new ArrayList<>();

    public void add(Object data) {
        list.add(data);
    }
    public Object get(int index) {
        return list.get(index);
    }
    public void remove(int index){
        list.remove(index);
        ArrayList <Object> newone = new ArrayList<>(list.size()-1);//копируем вручную
            }
}
