package ru.mirea.lab26;

import java.util.Scanner;

public class Exception2 {
    public void ExceptionDemo() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println( 2 / i );
        }catch (Exception e){
            System.out.println("Возникла ошибка:");
            e.printStackTrace();
        }finally {
            System.out.println("Эта надпись печатается в блоке finally");
        }
    }
}

