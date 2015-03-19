package dev.jichio.geemu.gfx;


import dev.jichio.geemu.Game;
import dev.jichio.geemu.entities.Entity;

public class GameCamera {

    private Game game;
    private float x0ffset, y0ffset;

    public GameCamera(Game game, float x0ffset, float y0ffset){
        this.game = game;
        this.x0ffset = x0ffset;
        this.y0ffset = y0ffset;
    }

    public void centerOnEnity(Entity e){
        x0ffset = e.getX() - game.getWidth()/ 2 + e.getWidth() /2;
        y0ffset = e.getY() - game.getHeight() / 2 + e.getHeight()/2;
    }

    public void move(float xAmt, float yAmt){
        x0ffset += xAmt;
        y0ffset += yAmt;
    }

    public float getX0ffset(){
        return x0ffset;
    }

    public void setX0ffset(float x0ffset){
        this.x0ffset = x0ffset;
    }

    public float getY0ffset(){
        return y0ffset;
    }

    public void setY0ffset(float y0ffset){
        this.y0ffset = y0ffset;
    }
}
