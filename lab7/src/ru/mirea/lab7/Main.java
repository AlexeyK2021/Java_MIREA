package ru.mirea.lab7;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Card> first = new ArrayDeque<Card>(5);
        ArrayDeque<Card> second = new ArrayDeque<Card>(5);
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) first.add(new Card(scan.nextInt()));

        for (int i = 0; i < 5; i++) second.add(new Card(scan.nextInt()));

        int actions = 0;
        while (first.size() > 0 && second.size() > 0) {
            if (actions >= 106) {
                System.out.println("botva");
                break;
            } else if (first.getFirst().getValue() > second.getFirst().getValue() || ((first.getFirst().getValue() == 0) && (second.getFirst().getValue() == 9))) {
                first.add(first.getFirst());
                first.add(second.getFirst());
                first.removeFirst();
                second.removeFirst();
                actions += 1;
            } else if (first.getFirst().getValue() < second.getFirst().getValue() || ((first.getFirst().getValue() == 9) && (second.getFirst().getValue() == 0))) {
                second.add(second.getFirst());
                second.add(first.getFirst());
                first.removeFirst();
                second.removeFirst();
                actions += 1;
            }
        }
        if (first.size() == 0) System.out.println("first " + actions);
        else if (second.size() == 0) System.out.println("second " + actions);
    }
}