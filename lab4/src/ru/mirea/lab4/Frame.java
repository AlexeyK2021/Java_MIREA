package ru.mirea.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Frame extends JFrame {
    JButton AC_Milan = new JButton("AC Milan");
    JButton Real_Madrid = new JButton("Real Madrid");
    JLabel result = new JLabel("Result 0X0");
    JLabel lastScorer = new JLabel("Last Scorer: N/A");
    JLabel winner = new JLabel("Winner: DRAW");
    Font font = new Font("Montserrat", Font.ITALIC, 20);
    int AC_Milan_Score = 0;
    int Real_Madrid_Score = 0;

    Frame() {
        super("Score counter");
        setLayout(new FlowLayout());
        setSize(300, 300);
        setVisible(true);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        AC_Milan.setFont(font);
        Real_Madrid.setFont(font);

        buttons.add(AC_Milan);
        buttons.add(Real_Madrid);
        add(buttons);

        JPanel results = new JPanel();
        results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));

        result.setFont(font);
        lastScorer.setFont(font);
        winner.setFont(font);

        results.add(result);
        results.add(lastScorer);
        results.add(winner);
        add(results);

        AC_Milan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AC_Milan_Score++;
                resultUpdater("AC Milan");
            }
        });
        Real_Madrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Real_Madrid_Score++;
                resultUpdater("Real Madrid");
            }
        });
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void resultUpdater(String goal) {
        result.setText("Result: " + AC_Milan_Score + "X" + Real_Madrid_Score);
        lastScorer.setText("Last Scorer: " + goal);
        if (AC_Milan_Score > Real_Madrid_Score) winner.setText("Winner: AC Milan");
        else if (AC_Milan_Score < Real_Madrid_Score) winner.setText("Winner: Real Madrid");
        else winner.setText("Winner: DRAW");

    }
}
