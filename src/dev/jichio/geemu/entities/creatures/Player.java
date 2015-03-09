package dev.jichio.geemu.entities.creatures;

import dev.jichio.geemu.Game;
import dev.jichio.geemu.gfx.Assets;

import java.awt.*;

public class Player extends Creature{

    private Game game;

    public Player(Game game,float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if(game.getKeyManager().up || game.getKeyManager().up1)
            y -=3;
        if(game.getKeyManager().down || game.getKeyManager().down1)
            y +=3;
        if(game.getKeyManager().left || game.getKeyManager().left1)
            x -=3;
        if(game.getKeyManager().right || game.getKeyManager().right1)
            x +=3;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
