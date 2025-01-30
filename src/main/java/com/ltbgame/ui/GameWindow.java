package com.ltbgame.ui;

import com.ltbgame.engine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final int width;
    private final int height;
    private final GameEngine gameEngine;
    private GamePanel gamePanel;

    public GameWindow(int width, int height, GameEngine gameEngine) {
        this.width = width;
        this.height = height;
        this.gameEngine = gameEngine;
        initialize();
    }

    private void initialize() {
        setTitle("My Java Game");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        gamePanel = new GamePanel(gameEngine);
        add(gamePanel, BorderLayout.CENTER);
    }

    public void start() {
        setVisible(true);
    }

    public void updateAgentInfo() {
        gamePanel.repaint();
    }
}