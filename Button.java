import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Button extends Actor
{
    private int positionX;
    
    public Button()
    {
        positionX=0;
        
    }
    
    public void act() 
    {
        animate();
        click();
    }   
   
    
    public void animate()
    {
        if(getX() < getWorld().getWidth()/2)
            move(positionX);
        else
        {
            setLocation(getWorld().getWidth()/2, getY());
            
        }
        if(positionX < 10)
            positionX++;
    }
    
    
    public  void click(){}  
}
