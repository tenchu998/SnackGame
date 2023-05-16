package com.practice;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JPanel {

    String type;
    int size;

    public Main() {
        type = JOptionPane.showInputDialog("選擇加法或乘法(加法為 A ，乘法為 M )");
        size = Integer.parseInt(JOptionPane.showInputDialog(" X * X 的表格大小，請輸入X "));
    }

    public void paintComponent(Graphics graphics) {

        int weight = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        int cellWidth = weight / size;
        int cellHeight = height / size;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i == 1 || j == 1) {
                    graphics.setColor(Color.pink);
                    graphics.fillRect(x, y, cellWidth, cellHeight);
                }
                graphics.setColor(Color.black);
                graphics.drawRect(x, y, cellWidth, cellHeight);
                if (i == 1) {
                    graphics.drawString(String.valueOf(j), x + 5, y + 15);
                } else if (j == 1) {
                    graphics.drawString(String.valueOf(i), x + 5, y + 15);
                } else {
                    int value;
                    if (type.equalsIgnoreCase("a")) {
                        value = i + j;
                    } else {
                        value = i * j;
                    }
                    graphics.drawString(String.valueOf(value), x + 5, y + 15);
                }

                x += cellWidth;
            }
            x = 0;
            y += cellHeight;
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setContentPane(new Main());
        window.setVisible(true);
    }
}