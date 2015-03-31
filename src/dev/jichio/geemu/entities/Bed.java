package dev.jichio.geemu.entities;

import dev.jichio.geemu.Game;
import dev.jichio.geemu.entities.creatures.Player;
import dev.jichio.geemu.gfx.Assets;

import java.awt.*;



public class Bed extends Entity {
    private Player thisPlayer;
    public Bed(Game game, Player player, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        thisPlayer = player;
    }

    public boolean stop() {
        if (game.getGameCamera().getX0ffset() + 304 >= x - thisPlayer.getWidth() &&
                game.getGameCamera().getY0ffset() + 212 >= y - thisPlayer.getHeight() &&
                game.getGameCamera().getX0ffset() + 304 <= x + width + thisPlayer.getWidth() &&
                game.getGameCamera().getY0ffset() + 212 <= y + height + thisPlayer.getHeight()){
            return true;
        }
        return false;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bed, (int) (x - game.getGameCamera().getX0ffset()), (int) (y - game.getGameCamera().getY0ffset()), width, height, null );
    }
}
