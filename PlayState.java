import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PlayState implements IStates 
{
    StateManager stateManager;
        
    PlayState(StateManager stateManager) {
        this.stateManager = stateManager;
    }
    
    public void changeWorld() {
        Greenfoot.setWorld(new Menu());
        stateManager.setNext("Menu");
    }
}
