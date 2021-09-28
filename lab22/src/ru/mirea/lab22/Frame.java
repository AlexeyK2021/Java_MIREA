package ru.mirea.lab22;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Frame extends JFrame {
    Scanner scan = new Scanner(System.in);

    Frame() {
        super("Animation");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        ArrayList<Image> images = new ArrayList<>();
        try {
            for (int i = 0; i < 6; i++) {
                BufferedImage img = ImageIO.read(new File("src/dice_images/dice_" + (i + 1) + ".png"));
                Image icon = new ImageIcon(img).getImage();
                images.add(icon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Images has been uploaded!");


        int ImgNumber = 1;
        while (true) {
            if (ImgNumber > 5) ImgNumber = 0;
            drawIcon(images.get(ImgNumber));
            ImgNumber++;
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawIcon(Image img) {
        Graphics g = getGraphics();
        g.drawImage(img, 50, 50, 200, 200, null);
    }

}
