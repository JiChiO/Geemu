package dev.jichio.geemu.states;


import dev.jichio.geemu.gfx.Assets;
import dev.jichio.geemu.states.State;

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
