package dev.jichio.geemu.worlds;

import dev.jichio.geemu.Game;
import dev.jichio.geemu.entities.Entity;
import dev.jichio.geemu.gfx.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Level extends Entity {
    private BufferedImage needRender;
    public Level(Game game, BufferedImage img,float x, float y, int width, int height) {
        super(game, x, y, width, height);
        needRender = img;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(needRender, (int) (x - game.getGameCamera().getX0ffset()), (int) (y - game.getGameCamera().getY0ffset()), width, height, null );
    }
}
