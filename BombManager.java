import greenfoot.*;

public class BombManager extends WorldObjectsManager 
{

    public BombManager(World world){
        super(world, 150);
    }

    public Actor getNewWorldObject(){
        return new Bomb(this);
    }
}
