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
            g.fillOval((int)agent.getX(),  (int)agent.getY(), 10, 10); // Draw agent as a small circle
        }
    }
}