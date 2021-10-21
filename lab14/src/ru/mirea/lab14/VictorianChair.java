package ru.mirea.lab14;

public class VictorianChair implements Chair{
    private int age;
    VictorianChair(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
