import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeSection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeSection extends Actor
{
    private ItemObserver snakeSectionHandler;
    
    public SnakeSection(ItemObserver snakeSectionHandler){
        this.snakeSectionHandler = snakeSectionHandler;
    }
    
    public void eaten(){
        getWorld().removeObject(this);
        snakeSectionHandler.itemEaten();
    }
    
}
