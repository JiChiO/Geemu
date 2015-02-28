package dev.jichio.geemu;


import dev.jichio.geemu.gfx.Assets;

import java.awt.Graphics;

public class GameState extends State {

    public GameState(){

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, 0, 0, null);
        //вместо player нужна нормальная текстурка.

    }
}
