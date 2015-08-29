import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Easy extends Button
{
    
    public void act() 
    {
        
        super.act();
        
    }
    
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
           
            LevelContext levelContext = new LevelContext();
            levelContext.changeStrategy(new EasyStrategy());
            levelContext.setSpeed();
            
            StateManager stateManager = StateManager.getInstance();
            stateManager.changeWorld();

        }
    }
}
