package com.game.chess;

import javax.swing.*;
import java.awt.*;

public class Board {
    public Board() {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 515, 540);
        JPanel jPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;
                // Horizontal Squares
                for (int y = 0; y < 8; y++) {
                    // Vertical Squares
                    for (int x = 0; x < 8; x++) {
                        if (white) {
                            g.setColor(Color.white);
                        } else {
                            g.setColor(Color.BLACK);
                        }
                        // 64 width and 64 height and x and y are the coordinates
                        g.fillRect(x * 64, y * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
            }

        };
        frame.add(jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
