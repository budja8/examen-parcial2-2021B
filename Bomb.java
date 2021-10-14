public class Bomb extends Item
{
    private int delayForNewBomb = 100;

    public Bomb(ItemObserver itemObserver){
        super(-30, itemObserver, 100);
    }

}
