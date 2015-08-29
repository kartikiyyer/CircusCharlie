import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Hard extends Button
{
    
    public void act() 
    {
        
        super.act();
        
    }    
    
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            
            LevelContext levelContext = new LevelContext();
            levelContext.changeStrategy(new HardStrategy());
            levelContext.setSpeed();
            
            StateManager stateManager = StateManager.getInstance();
            stateManager.changeWorld();
        }
    }
}
