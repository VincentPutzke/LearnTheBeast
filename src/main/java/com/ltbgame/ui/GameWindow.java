package com.ltbgame.ui;

import javax.swing.*;
// import java.awt.*;

public class GameWindow extends JFrame {
    private final int width;
    private final int height;

    public GameWindow(int width, int height) {
        this.width = width;
        this.height = height;
        initialize();
    }

    private void initialize() {
        setTitle("My Java Game");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void start() {
        setVisible(true);
    }

    public static void main(String[] args) {
        GameWindow window = new GameWindow(800, 600);
        window.start();
    }
}