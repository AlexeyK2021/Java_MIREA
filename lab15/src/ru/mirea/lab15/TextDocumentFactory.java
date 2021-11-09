package ru.mirea.lab15;

public class TextDocumentFactory implements ICreateDocument{
    @Override
    public IDocument CreateNew() {
        return new TextDocument();
    }

    @Override
    public IDocument CreateOpen() {
        return new TextDocument();
    }
}
