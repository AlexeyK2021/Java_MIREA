package ru.mirea.lab14;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ChairFactory chairFactory = new ChairFactory();
        Chair functionalChair = chairFactory.createFunctionalChair();
        Chair magicChair = chairFactory.createMagicanChair();
        Chair victorianChair = chairFactory.createVictorianChair();

        client.setChair(functionalChair);
        client.sit();

        client.setChair(magicChair);
        ((MagicChair) client.chair).doMagic();

        client.setChair(victorianChair);
        System.out.println(((VictorianChair) client.chair).getAge());
    }
}
