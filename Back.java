import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Back extends Button
{
   private Actor actor;
    /**
     * Constructor de la clase Back.
     */
    public Back()
    {
        
    }
    
  
    public void act() 
    {
        this.click();
    }    
    

    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
           
            Greenfoot.setWorld(new Menu());
        }
    }  
}
