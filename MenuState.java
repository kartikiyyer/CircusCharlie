import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MenuState implements IStates
{
    StateManager stateManager;
    
    MenuState(StateManager stateManager) {
        this.stateManager = stateManager;
    }        
    
    public void changeWorld() {
        Greenfoot.setWorld(new Circus());
        stateManager.setNext("Play");
    }
    
}
