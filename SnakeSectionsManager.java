import greenfoot.*;

public class SnakeSectionsManager extends WorldObjectsManager
{
    private static final int INITIAL_DELAY = 100;
    
    public SnakeSectionsManager(World world){
        super(world, INITIAL_DELAY);
    }
       
    public Actor getNewWorldObject(){
        return new SnakeSection(this);
    }
}
