package com.ltbgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppTest {

    @Test
    public void testConfigLoading() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            fail("Failed to load config file");
        }

        assertEquals("800", config.getProperty("window.width"));
        assertEquals("800", config.getProperty("window.height"));
    }

    public static void main(String[] args) {
        AppTest test = new AppTest();
        test.testConfigLoading();
    }
}