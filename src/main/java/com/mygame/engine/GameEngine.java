public class GameEngine {
    private boolean running;
    private final int targetFPS = 60;
    private final long optimalTime = 1000000000 / targetFPS;

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
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            double delta = updateLength / ((double) optimalTime);
            update(delta);
            render();

            try {
                Thread.sleep(Math.max(0, (lastLoopTime - System.nanoTime() + optimalTime) / 1000000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update(double delta) {
        // Update game state
    }

    private void render() {
        // Render game world
    }
}