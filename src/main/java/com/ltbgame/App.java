package com.ltbgame;

import com.ltbgame.engine.GameEngine;
import com.ltbgame.ui.GameWindow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.Timer;

public class App {
    public static void main(String[] args) {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int width = Integer.parseInt(config.getProperty("window.width", "800"));
        int height = Integer.parseInt(config.getProperty("window.height", "600"));

        GameEngine gameEngine = new GameEngine();
        GameWindow window = new GameWindow(width, height, gameEngine);
        window.start();

        gameEngine.start();

        Timer timer = new Timer(100, e -> window.updateAgentInfo());
        timer.start();
    }
}