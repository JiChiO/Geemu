package dev.jichio.geemu.entities.creatures;

import dev.jichio.geemu.Game;
import dev.jichio.geemu.gfx.Assets;

import java.awt.*;

public class Player extends Creature{

    private Game game;

    public Player(Game game,float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().up || game.getKeyManager().up1)
            yMove = -speed;
        if (game.getKeyManager().down || game.getKeyManager().down1)
            yMove = speed;
        if (game.getKeyManager().left || game.getKeyManager().left1)
            xMove = -speed;
        if (game.getKeyManager().right || game.getKeyManager().right1)
            xMove = speed;


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
    }
}
