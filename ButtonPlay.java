import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ButtonPlay extends Button
{
    
    public void act() 
    {
        super.act();
    }    
    
   
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            
           StateManager stateManager = StateManager.getInstance();
           stateManager.changeWorld();

        }
    }  
}
