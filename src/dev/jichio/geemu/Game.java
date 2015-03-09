package dev.jichio.geemu;

import dev.jichio.geemu.display.Display;
import dev.jichio.geemu.gfx.Assets;
import dev.jichio.geemu.states.GameState;
import dev.jichio.geemu.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    private Display display;
    public  int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //Структура игры (меню, настройки etc...)
    private State gameState;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;


    }

    private void init(){
        display = new Display(title, width, height);
        Assets.init();
        gameState = new GameState();
        State.setState(gameState);
    }

    private void tick(){
        if (State.getState() != null)
            State.getState().tick();
    }

    int x = 0;
    //начальная координата для тестовой картинки


    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Это очистит экран
        g.clearRect(0,0, width, height);
        //Начали рисовать

        if (State.getState() != null)
            State.getState().render(g);


        //Закончили
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000){
                System.out.println("Tick and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
