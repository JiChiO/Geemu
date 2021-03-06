package dev.jichio.geemu.entities.creatures;

import dev.jichio.geemu.Game;
import dev.jichio.geemu.gfx.Assets;
import dev.jichio.geemu.text.TextLoader;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    private BufferedImage pureeru = Assets.playerFront;
    private int numFrame = 1, direction = 3, rate = 10, run = 1;
    private int[][] tiles;
    //direction - направление: 1 == back; 2 == righ; 3 == front; 4 == left;

    public Player(Game game,float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        loadWorld("/worlds/world1.txt");
    }

    @Override
    public void tick() {
        getInput();
        move();

        System.out.print(x);
        System.out.print(" ");
        System.out.println(y);
        game.getGameCamera().centerOnEnity(this);
    }

    private boolean runDirect(String s){
        int ty = 0;
        int tx = 0;
        float xx = x + 25;
        float yy = y + 50;

        if (s == "up"){
            ty = (int)((yy-speed)/100);
            tx = (int)(xx/100);
        }
        if (s == "right"){
            ty = (int)(yy/100);
            tx = (int)((xx+speed)/100);
        }
        if (s == "down"){
            ty = (int)((yy+speed)/100);
            tx = (int)(xx/100);
        }
        if (s == "left"){
            ty = (int)(yy/100);
            tx = (int)((xx-speed)/100);
        }

        if(tiles[tx][ty] > 0){return false;}
        return true;
    }

    private boolean up(){
        if (game.getKeyManager().up || game.getKeyManager().up1) {
            run = 1;
            yMove = -speed;
            if (direction != 1){
                direction = 1;
                numFrame = 1;
            }
            if (numFrame == 1){
                pureeru = Assets.playerBack;
            }
            if (numFrame == rate) {
                pureeru = Assets.playerBackLF;
            }
            if (numFrame == 2 * rate) {
                pureeru = Assets.playerBack;
            }
            if (numFrame == 3 * rate) {
                pureeru = Assets.playerBackRF;
            }
            if(!runDirect("up")){
                yMove = 0;
            }
            numFrame ++;
            if(numFrame == 4 * rate + 1){numFrame = 1;}
            return true;

        }
        return false;
    }
    private boolean down(){
        if (game.getKeyManager().down || game.getKeyManager().down1){
            run = 1;
            yMove = speed;
            if (direction != 3){
                direction = 3;
                numFrame = 1;
            }
            if (numFrame == 1){
                pureeru = Assets.playerFront;
            }
            if (numFrame == rate) {
                pureeru = Assets.playerFrontLF;
            }
            if (numFrame == 2 * rate) {
                pureeru = Assets.playerFront;
            }
            if (numFrame == 3 * rate) {
                pureeru = Assets.playerFrontRF;
            }
            if(!runDirect("down")){
                yMove = 0;
            }
            numFrame ++;
            if(numFrame == 4 * rate + 1){numFrame = 1;}
            return true;
        }
        return false;
    }
    private boolean left(){
        if (game.getKeyManager().left || game.getKeyManager().left1){
            run = 1;
            xMove = -speed;
            if (direction != 4){
                direction = 4;
                numFrame = 1;
            }
            if (numFrame == 1){
                pureeru = Assets.playerLeft;
            }
            if (numFrame == rate) {
                pureeru = Assets.playerLeftHF;
            }
            if (numFrame == 2 * rate) {
                pureeru = Assets.playerLeft;
            }
            if (numFrame == 3 * rate) {
                pureeru = Assets.playerLeftHB;
            }
            if(!runDirect("left")){
                xMove = 0;
            }
            numFrame ++;
            if(numFrame == 4 * rate + 1){numFrame = 1;}
            return true;
        }
        return false;
    }
    private boolean right(){
        if (game.getKeyManager().right || game.getKeyManager().right1){
            run = 1;
            xMove = speed;
            if (direction != 2){
                direction = 2;
                numFrame = 1;
            }
            if (numFrame == 1){
                pureeru = Assets.playerRight;
            }
            if (numFrame == rate) {
                pureeru = Assets.playerRightHF;
            }
            if (numFrame == 2 * rate) {
                pureeru = Assets.playerRight;
            }
            if (numFrame == 3 * rate) {
                pureeru = Assets.playerRightHB;
            }
            if(!runDirect("right")){
                xMove = 0;
            }
            numFrame ++;
            if(numFrame == 4 * rate + 1){numFrame = 1;}
            return true;
        }
        return false;
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;
        run = 0;
        if((direction == 1) && (!up())){
            down();
            left();
            right();
        }
        if((direction == 2) && (!right())){
            up();
            left();
            down();
        }
        if((direction == 3) && (!down())){
            up();
            left();
            right();
        }
        if((direction == 4) && (!left())){
            up();
            down();
            right();
        }
        if(run == 0){
            if(direction == 1){pureeru = Assets.playerBack;}
            if(direction == 2){pureeru = Assets.playerRight;}
            if(direction == 3){pureeru = Assets.playerFront;}
            if(direction == 4){pureeru = Assets.playerLeft;}
            numFrame = 1;
        }
    }

    private void loadWorld(String path){
        String file = TextLoader.loadText(path);
        //System.out.print(path);
        String[] tokens = file.split("\\s+");
        int Xwidth = TextLoader.parseInt(tokens[0]);
        int Yheight = TextLoader.parseInt(tokens[1]);
        tiles = new int[Xwidth][Yheight];
        for (int y = 0;y < Yheight;y++){
            for (int x = 0; x< Xwidth;x++){
                tiles[x][y] = TextLoader.parseInt(tokens[(x + y * Xwidth) + 4]);
                System.out.print(tiles[x][y]);
            }
            System.out.println(" ");
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(pureeru, (int) (x - game.getGameCamera().getX0ffset()),
                (int) (y - game.getGameCamera().getY0ffset()), width, height, null);
    }
}
