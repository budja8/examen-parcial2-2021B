import greenfoot.*;

public class WorldObjectsManager implements ItemObserver
{
    private final int initialDelay;
    private int delayNewObject;
    private boolean enableNewItemCounter;
    private Actor actor;
    private World world;
    private int worldHeight;
    
    public WorldObjectsManager(World world, int initialDelay){
        this.world = world;
        this.initialDelay = initialDelay;
        this.delayNewObject = initialDelay;
        enableNewItemCounter = true;
    }
    
    public void addObject(){
        if(!enableNewItemCounter){
            return;
        }

        delayNewObject --;

        if(delayNewObject == 0){
            Actor worldObject = getNewWorldObject();

            if(worldObject != null){
                world.addObject(worldObject, Greenfoot.getRandomNumber(world.getWidth()), Greenfoot.getRandomNumber(world.getHeight()));
            }

            delayNewObject = initialDelay;
            enableNewItemCounter = false;
        }    
    }
    
    public void itemEaten(){
        enableNewItemCounter = true;
    }
    
    public Actor getNewWorldObject(){
        return new SnakeSection(this);
    }
}
