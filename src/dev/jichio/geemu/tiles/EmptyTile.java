package dev.jichio.geemu.tiles;


import dev.jichio.geemu.gfx.Assets;

public class EmptyTile extends Tile{
    public EmptyTile (int id) {
        super(Assets.empty, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}