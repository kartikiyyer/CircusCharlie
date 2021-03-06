import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class LevelWorld extends KinectWorld
{
     private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    /**
     * Constructor for objects of class LevelWorld.
     * 
     */
    public LevelWorld()
    {    
       
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
        
        prepare();
    }
    
    public void act() {
        click();
    }
    
 
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            
            Greenfoot.setWorld(new Menu());
        }
    }
    
    public void prepare() {
        addObject(new Easy(), -200, 260);
        addObject(new Medium(), -400, 360);
        addObject(new Hard(), -600, 460);
        addObject(new Back(), 50, 50);
    }
}
