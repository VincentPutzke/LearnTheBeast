package com.ltbgame.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.ltbgame.agents.Agent;

public class GameEngine {
    private final int MAX_AGENTS = 1000;
    
    
    private Random random;
    
    private boolean running;
    private final int targetFPS = 60;
    private final long optimalTime = 1000000000 / targetFPS;
    
    private int update_index = 0;
    private float rps_0 = 0;
    private float rps_1 = 0;
    private float rps_2 = 0;
    private float rps_3 = 0;
    private float rps_4 = 0;
    private float rps = 0;
    
    private List<Agent> agents;
    
    public GameEngine() {
        this.random = new Random(123456);
        this.running = false;
        this.agents = new ArrayList<>();
        for (int i = 0; i <= MAX_AGENTS; i++) {
            agents.add(new Agent(random.nextDouble(), random.nextDouble(), random.nextDouble(), random));
        }
        
    }
    
    public void start() {
        running = true;
        runGameLoop();
    }

    public void stop() {
        running = false;
    }

    private void runGameLoop() {
        long lastLoopTime = System.nanoTime();
        while (running) {
            this.update_index++;
            
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            double delta = updateLength / ((double) optimalTime);
            update(delta);

            try {
                Thread.sleep(Math.max(0, (lastLoopTime - System.nanoTime() + optimalTime) / 1000000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            switch (update_index % 25) {
                case 0:
                    rps_0 = 1000000000 / updateLength;
                    break;
                case 5:
                    rps_1 = 1000000000 / updateLength;
                    break;
                case 10:
                    rps_2 = 1000000000 / updateLength;
                    break;
                case 15:
                    rps_3 = 1000000000 / updateLength;
                    break;
                case 20:
                    rps_4 = 1000000000 / updateLength;
                    break;
                default:
                    break;
            }
            
            update_index %= 25;
            this.rps = (rps_0 + rps_1 + rps_2 + rps_3 + rps_4) / 5;
        }
    }

    private void update(double delta) {
        for (Agent agent : agents) {
            agent.update(delta);
        }
    }

    public List<Agent> getAgentsInfo() {
        return agents;
    }
    
    public float getRPS() {
        return rps;
    }
}