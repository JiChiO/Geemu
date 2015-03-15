package dev.jichio.geemu.states;


import dev.jichio.geemu.Game;
import dev.jichio.geemu.tiles.Tile;
import dev.jichio.geemu.entities.creatures.Player;
import dev.jichio.geemu.gfx.Assets;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 350, 150);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.train, 0, 0, null);
        player.render(g);
        //стереть
        Tile.tiles[0].render(g, 0, 0);
        //стереть
    }
}
