import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SnakeWorld extends World implements GameOverObserver, HudHandler
{
    private boolean gameFinished = false;
    private final SnakeSectionsManager snakeSectionsManager;
    private final ItemsManager itemsManager;
    private final BombManager bombManager;

    public SnakeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
        
        snakeSectionsManager = new SnakeSectionsManager(this);
        itemsManager = new ItemsManager(this);
        bombManager = new BombManager(this);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Snake snakeHead = new Snake(this);

        addObject(snakeHead,62,67);

        snakeHead.addGameOverObserver(this);
    }

    public void act(){

        if(gameFinished){
            return;
        }
        
        snakeSectionsManager.addObject();
        
        itemsManager.addObject();
        
        bombManager.addObject();

    }

    public void onGameOver(){
        gameFinished = true;
        this.showText("Game Over", getWidth() / 2, getHeight() / 2 - 30);
    }
    
    public void showScore(int score){
        showText("Puntos: " + score, getWidth() - 200, 40);
    }
    

}
