import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
import java.util.LinkedList;

/**
 * Write a description of class SnakeHead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    private static final int DELAY_START_VALUE = 8;
    private static final int OFFSET = 20;
    private static final int UP_ROTATION = 270;
    private static final int DOWN_ROTATION = 90;
    private static final int RIGHT_ROTATION = 0;
    private static final int LEFT_ROTATION = 180;
    
    private List<SnakeTail> tail;
    private List<GameOverObserver> gameOverObservers;
    private int delayCounter = DELAY_START_VALUE;
    private boolean gameOver = false;
    private HudHandler hudHandler;
    private int score;
    
    public Snake(HudHandler hudHandler){
        tail = new LinkedList<>();
        gameOverObservers = new LinkedList<>();
        
        this.hudHandler = hudHandler;
    }
    
    public void act()
    {
        if(this.gameOver){
            return;
        }
        
        moveSnake();
        
        handleKeys();
        
        eatItems();
        
        intersectSnakeSections();
        
        if(isAtEdge()){
            finishGame();
        } 
    }
    
    public void addGameOverObserver(GameOverObserver gameOverObserver){
        gameOverObservers.add(gameOverObserver);
    }
    
    private void eatItems(){
        Item item = (Item)getOneIntersectingObject(Item.class);
        
        if(item != null){
            score += item.eaten();
            hudHandler.showScore(score);
            
            if(score < 0){
                finishGame();
            }
        }
    }
    
    private void intersectSnakeSections(){
        SnakeSection snakeSection = (SnakeSection)getOneIntersectingObject(SnakeSection.class);
        
        if(snakeSection != null){
            snakeSection.eaten();
            addTail();
            score += 5;
            hudHandler.showScore(score);
        }
    }
    
    private void finishGame(){
        this.gameOver = true;
        
        for(GameOverObserver observer: gameOverObservers){
            observer.onGameOver();
        }
    }
    
    public static void moveSnake(){
        
        delayCounter--;
        
        if(delayCounter > 0)
            return;
        
        int x = getX();
        int y = getY();
        
        move(OFFSET);
        
        for(SnakeTail snakeTail: tail){
            if(snakeTail.getWorld() == null){
                getWorld().addObject(snakeTail, x, y);
            } else {
                int itemX = snakeTail.getX();
                int itemY = snakeTail.getY();
                snakeTail.setLocation(x, y);
                x = itemX;
                y = itemY;
            }
        }
        
        delayCounter = DELAY_START_VALUE;
    }
    
    public void addTail(){
        SnakeTail snakeTail = new SnakeTail();
        
        tail.add(snakeTail);        
    }
    
    
    private void handleKeys()
    {
        int currentRotation = getRotation();
        
        if(Greenfoot.isKeyDown("down") && currentRotation != UP_ROTATION){
            setRotation(DOWN_ROTATION);
        } else if(Greenfoot.isKeyDown("up") && currentRotation != DOWN_ROTATION ){
            setRotation(UP_ROTATION);
        } else if(Greenfoot.isKeyDown("right") && currentRotation != LEFT_ROTATION){
            setRotation(RIGHT_ROTATION);
        } else if(Greenfoot.isKeyDown("left") && currentRotation != RIGHT_ROTATION){
            setRotation(LEFT_ROTATION);
        }
    }
    

}
