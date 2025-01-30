package com.ltbgame.agents;

import java.util.Random;
import java.lang.Math;

public class Agent {
    private Random random;
    
    private double x;
    private double y;
    private double speed;
    private double x_speed = 1d;
    private double y_speed = 0d;

    public Agent(double x, double y, double speed, Random random) {
        this.random = random;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.x_speed = random.nextDouble()-0.5d;
        this.y_speed = random.nextDouble()-0.5d;
    }

    public void move() {
        this.x = Math.min(0.99d * 1d, Math.max(this.x + x_speed * speed * 0.001d, 0));
        this.y = Math.min(0.99d * 1d, Math.max(this.y + y_speed * speed * 0.001d, 0));
    }
    
    public void adjustSpeed() {
        double ang_speed = 1d;
        double angle = Math.atan2(this.y_speed, this.x_speed);
        double angleAdjustment = (random.nextDouble()-0.5d)*0.4d;
        double guard = random.nextDouble();
        if (guard < 0.85) {
            angleAdjustment = 0;
        }
        angle += angleAdjustment;
        this.x_speed = ang_speed * Math.cos(angle);
        this.y_speed = ang_speed * Math.sin(angle);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getSpeed() {
        return this.speed;
    }
    
    public double getXSpeed() {
        return this.x_speed;
    }
    
    public double getYSpeed() {
        return this.y_speed;
    }
    
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(double delta) {
        this.move();
        this.adjustSpeed();
    }
}