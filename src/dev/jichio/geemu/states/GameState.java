package dev.jichio.geemu.states;


import dev.jichio.geemu.entities.creatures.Player;
import dev.jichio.geemu.gfx.Assets;
import dev.jichio.geemu.states.State;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;

    public GameState(){
        player = new Player(100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
