import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Medium extends Button
{
    /**
     * Act - do whatever the Medium wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        super.act();
        
    }   
    
    /**
     * Cierra la ventana para ver nuevamente el menu.
     */
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            
            LevelContext levelContext = new LevelContext();
            levelContext.changeStrategy(new MediumStrategy());
            levelContext.setSpeed();
           
            StateManager stateManager = StateManager.getInstance();
            stateManager.changeWorld();
        }
    }
}
