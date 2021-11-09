package ru.mirea.lab15;

public class MusicDocument implements IDocument{
    private String name;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
