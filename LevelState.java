import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class LevelState implements IStates  
{
    StateManager stateManager;
    
    LevelState(StateManager stateManager) {
        this.stateManager = stateManager;
    }        
    
    public void changeWorld() {
        Greenfoot.setWorld(new Circus());
        stateManager.setNext("Play");
    }
}
