package dev.jichio.geemu.entities;

import dev.jichio.geemu.Game;
import dev.jichio.geemu.gfx.Assets;

import java.awt.*;


public class Bed extends Entity {
    public Bed(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bed, (int) (x - game.getGameCamera().getX0ffset()), (int) (y- game.getGameCamera().getY0ffset()), width, height, null );
    }
}
