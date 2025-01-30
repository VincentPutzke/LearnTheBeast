package com.ltbgame.ui;

import com.ltbgame.agents.Agent;
import com.ltbgame.engine.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private final GameEngine gameEngine;

    public GamePanel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Agent> agents = gameEngine.getAgentsInfo();
        for (Agent agent : agents) {
            g.fillOval((int) (this.getWidth() * agent.getX()), (int) (this.getHeight() * agent.getY()), 5, 5); // Draw agent as a small circle
        }
        float rps = gameEngine.getRPS();
        g.drawString("RPS: " + rps, 10, 10);
    }
}