import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Item extends Actor
{
    private int points;
    private ItemObserver observer;
    private int delayToShow;
    
    protected Item(int points, ItemObserver observer, int delayToShow){
        this.points = points;
        this.observer = observer;
        this.delayToShow = delayToShow;
    }
    
    public int eaten(){
        getWorld().removeObject(this);
        observer.itemEaten();
        return points;
    }
    
    public void act(){
        if(delayToShow <= 0){
            return;
        }
        
        delayToShow--;
        
        if(delayToShow == 0){
            observer.itemEaten();
        }
        
    }
}
