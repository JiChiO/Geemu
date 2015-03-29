package dev.jichio.geemu.states;


import dev.jichio.geemu.Game;
import dev.jichio.geemu.entities.Bed;
import dev.jichio.geemu.entities.creatures.Player;
import dev.jichio.geemu.gfx.Assets;
import dev.jichio.geemu.worlds.Level;
import dev.jichio.geemu.worlds.World;
import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;
    private Bed bed;
    private Level level;
    private Level BB;

    public GameState(Game game){
        super(game);
        player = new Player(game, 0, 0);
        bed = new Bed(game, 130, -68, Assets.bed.getWidth(), Assets.bed.getHeight());
        level = new Level(game, Assets.mainRoom, -512, -384, Assets.mainRoom.getWidth(), Assets.mainRoom.getHeight());
        BB = new Level(game, Assets.BB, -2000, -2000, Assets.BB.getWidth(), Assets.BB.getHeight());
        //level = new Level(game, Assets.mainRoom, -512, -384, Assets.mainRoom.getWidth(), Assets.mainRoom.getHeight());
        //world = new World(game, "/worlds/world1.txt");

    }

    @Override
    public void tick() {
        //BB.tick();
        //level.tick();
        player.tick();
        //bed.tick();
    }

    @Override
    public void render(Graphics g) {
        BB.render(g);
        level.render(g);
        player.render(g);
        bed.render(g);
    }
}
