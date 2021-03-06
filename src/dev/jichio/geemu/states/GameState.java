package dev.jichio.geemu.states;


import dev.jichio.geemu.Game;
import dev.jichio.geemu.entities.creatures.Player;
import dev.jichio.geemu.worlds.World;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;
    public GameState(Game game){
        super(game);
        player = new Player(game, 3400, 500);
        world = new World(game, "/worlds/world1.txt");

    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
