import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Menu extends KinectWorld
{
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;

    
    private ButtonPlay buttonplay;
   
    public Menu()
    {     
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false); 
        
        
        ButtonPlay buttonPlay = new ButtonPlay();
        prepare();
    }
    
    public void act()
    {
        
    }
    
    
    public void prepare()
    {
        addObject(new ButtonPlay(), -200, 260);
        addObject(new ButtonCredits(), -600, 360);
        addObject(new ButtonLevels(), -800, 460);
        
    }
}
