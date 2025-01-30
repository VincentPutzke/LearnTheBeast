package com.ltbgame.agents;

public class Agent {
    private float x;
    private float y;
    private float speed;

    public Agent(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void move(float deltaX, float deltaY) {
        this.x += deltaX * speed;
        this.y += deltaY * speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        // Update agent behavior here
    }
}