package dev.jichio.geemu.worlds;

import dev.jichio.geemu.text.TextLoader;
import dev.jichio.geemu.tiles.Tile;

import java.awt.*;

public class World {

    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(String path){
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics g){
        for (int y = 0;y < height;y++){
            for (int x = 0;x < width;x++){
                getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.stoneTile;
        return t;
    }

    private void loadWorld(String path){
       String file = TextLoader.loadText(path);
        System.out.print(path);
        String[] tokens = file.split("\\s+");
        width = TextLoader.parseInt(tokens[0]);
        height = TextLoader.parseInt(tokens[1]);
        spawnX = TextLoader.parseInt(tokens[2]);
        spawnY = TextLoader.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0;y < height;y++){
            for (int x = 0; x< width;x++){
                tiles[x][y] = TextLoader.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

}
