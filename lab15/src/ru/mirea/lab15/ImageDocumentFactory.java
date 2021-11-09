package ru.mirea.lab15;

public class ImageDocumentFactory implements ICreateDocument{
    @Override
    public IDocument CreateNew() {
        return new ImageDocument();
    }

    @Override
    public IDocument CreateOpen() {
        return new ImageDocument();
    }
}
