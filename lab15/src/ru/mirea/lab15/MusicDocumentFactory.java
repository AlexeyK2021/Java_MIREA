package ru.mirea.lab15;

public class MusicDocumentFactory implements ICreateDocument{
     @Override
     public IDocument CreateNew(){
       return new MusicDocument();
     }

     @Override
     public IDocument CreateOpen(){
       return new MusicDocument();
     }
}
