
public class StateManager  
{
    IStates iState;
    MenuState menuState;
    PlayState playState;
    LevelState levelState;
    private static StateManager stateManager;
    
    
    private StateManager() {
        
        menuState = new MenuState(this);
        playState = new PlayState(this);
        levelState = new LevelState(this);
        iState = menuState;
    }
    
    public static StateManager getInstance() {
        if(stateManager == null) {
            stateManager = new StateManager();
        }
        return stateManager;
    }
    
    public void setNext(String world) {
        if(world.equals("Menu")) {
            iState = menuState;
        } else if(world.equals("Play")) {
            iState = playState;
        }
    }
    
    public void changeWorld() {
        iState.changeWorld();
    }
}
