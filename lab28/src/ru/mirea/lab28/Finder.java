package ru.mirea.lab28;

import java.io.File;
import java.util.ArrayList;

public class Finder {
    ArrayList<File> files;

    public void Find(String path) {
        files = new ArrayList<>();
        File folder = new File(path);
        for (File file : folder.listFiles()) {
            files.add(file);
        }
    }

    public void printFiveFirst() {
        System.out.println("Founded first five files:");
        int size = files.size();
        if (files.size() > 5) size = 5;

        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + ") " + files.get(i).getName());
        }
    }
}
