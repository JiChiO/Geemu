package dev.jichio.geemu.tiles;


import dev.jichio.geemu.gfx.Assets;

public class YobaTile extends Tile{
    public YobaTile (int id) {
        super(Assets.yoba, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
