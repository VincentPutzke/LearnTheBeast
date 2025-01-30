package com.ltbgame.ui;

import com.ltbgame.engine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final int width;
    private final int height;
    private final GameEngine gameEngine;
    private GamePanel gamePanel;
    
    private Timer timer;
    
    public GameWindow(int width, int height, GameEngine gameEngine) {
        this.width = width;
        this.height = height;
        this.gameEngine = gameEngine;
        initialize();
        
        this.timer = new Timer((int) (1000f / 60f), e -> updateScreen());
        this.timer.start();
    }

    private void initialize() {
        setTitle("LearnTheBeast");
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

    public void updateScreen() {
        gamePanel.repaint();
    }
}