
public class LevelContext  
{

    private IStrategy strategy;
    
   
    public LevelContext()
    {
        strategy = new EasyStrategy();
    }

    public void changeStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setSpeed() {
        strategy.setSpeed();
    }
}