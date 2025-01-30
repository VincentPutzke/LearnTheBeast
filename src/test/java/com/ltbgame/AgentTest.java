package com.ltbgame;

import com.ltbgame.agents.Agent;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class AgentTest {

    @Test
    public void testAgentInitialization() {
        Agent agent = new Agent(0, 1, 1, new Random(1));
        assertEquals(0, agent.getX());
        assertEquals(1, agent.getY());
        assertEquals(0, agent.getXSpeed());
        assertEquals(1, agent.getYSpeed());
        assertEquals(1, agent.getSpeed());
    }
    
    public static void main(String[] args) {
        AgentTest test = new AgentTest();
        test.testAgentInitialization();
    }
    
}
