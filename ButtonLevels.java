import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ButtonLevels extends Button
{
    
    
    public ButtonLevels()
    {
       
    }
    
    
    public void act() 
    {
        super.act();
    }    
    
   
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            
            Greenfoot.setWorld(new LevelWorld());
        }
    }    
}
