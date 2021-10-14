import greenfoot.*;

import java.util.ArrayList;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ItemsManager extends WorldObjectsManager 
{
    private Random random = new Random();

    public ItemsManager(World world){
        super(world, 60);
    }

    public Actor getNewWorldObject(){

        int randomOption = random.nextInt(4);

        switch(randomOption){
            case 0:
                return new Apple(this);
            case 1:
                return new AppleGreen(this);
            case 2:
                return new Strowberry(this);
            default:
                return new Bomb(this);
        }

    }
}
