package ru.mirea.lab15;

public class ImageDocument implements IDocument{
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
