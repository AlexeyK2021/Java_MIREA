package ru.mirea.lab15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    ICreateDocument textDocumentFactory = new TextDocumentFactory();
    IDocument document = null;

    Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 300);

        MenuBar menuBar = new MenuBar();
        PopupMenu file = new PopupMenu("File");

        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Exit = new MenuItem("Exit");
        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(Exit);

        menuBar.add(file);
        setMenuBar(menuBar);

        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                document = textDocumentFactory.CreateNew();
                JOptionPane.showMessageDialog(null, "Created new Document file!");
                System.out.println("Created new IDocument file!");
            }
        });
        Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                document = textDocumentFactory.CreateOpen();
                JOptionPane.showMessageDialog(null, "Opened Document file!");
                System.out.println("Opened IDocument file!");
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting");
                JOptionPane.showMessageDialog(null, "Exiting");
                System.exit(0);
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Document saved!");
                JOptionPane.showMessageDialog(null, "Document saved!");
            }
        });
    }

}
