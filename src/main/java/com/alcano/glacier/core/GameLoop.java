package com.alcano.glacier.core;

import com.alcano.glacier.scene.SceneManager;

public final class GameLoop implements Runnable {

    private Thread thread;
    private boolean running;

    public synchronized void start() {
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }

    public synchronized void stop() {
        try {
            this.thread.join();
            this.running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int fps = 60;
        double timePerTick = 1000000000D / fps;
        double delta = 0;
        long now;
        long last = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        while (this.running) {
            now = System.nanoTime();
            delta += (now - last) / timePerTick;
            timer += now - last;
            last = now;

            if (delta >= 1) {
                this.update();
                ticks++;
                delta--;
            }
            this.render();

            if (timer >= 1000000000) {
                System.out.println("FPS: " + ticks);
                timer = 0;
                ticks = 0;
            }
        }

        this.stop();
    }

    private void update() {
        SceneManager.updateCurrentScene();
    }

    private void render() {
        GlacierAPI.getGameWindow().render();
    }

    public boolean isRunning() {
        return running;
    }
}
