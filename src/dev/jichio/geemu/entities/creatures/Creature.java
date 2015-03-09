package dev.jichio.geemu.entities.creatures;

import dev.jichio.geemu.entities.Entity;

public abstract class Creature extends Entity {

    protected int health;

    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }
}
