import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Circus extends KinectWorld
{
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;
    private long leftHandUp;
    private Label leftHandWarning;
    GreenfootImage bckgrndimage,bckgrndimage2;
    public int x,x2,score,distance;
    Label labelObj;
    FinishPost target;
    ScoreDisplayer scoreDisplayer;
    LifeDisplayer lifeDisplayer;
    ArrayList<String> charlieimages;
    String charlieJumpImage;
    int charlieSmallJump,charlieLongJump,charlielevel;
    
    Charlie charlie;
    Charlie charlie2;
    IState istate;
    int level=1;
    int levelFlag=1;
    int levelhurdleHeight,targetlevel;
    IHurdle ihurdle;
    LevelOneFactory levelOneFactory;
    LevelTwoFactory levelTwoFactory;
    GreenfootSound sound;
    public Circus()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
         
        sound = new GreenfootSound("CircusCharlie.mp3");
        sound.play();
        x=0;
        final int width = getWidth();
        final int height = getHeight();
       
        if(level==1)
        {
            istate = new LevelOneState();
            level=0;
            charlieJumpImage="07.png";
            charlieimages = istate.changeCharlie();
            charlie=new Charlie(charlieimages);
            levelhurdleHeight=400;
            charlieSmallJump=340;
            charlieLongJump=310;
            charlielevel=380;
            targetlevel=400;
            addObject(charlie,150,charlielevel);
            bckgrndimage=bckgrndimage2 = istate.changeBG();
        }
        addObject(new Instructions(), width/2, height/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        
        scoreDisplayer=new ScoreDisplayer();
        addObject(scoreDisplayer,800,30);
        charlie.attachObserver(scoreDisplayer);
         
        lifeDisplayer=new LifeDisplayer(sound);
        addObject(lifeDisplayer,600,30);
        charlie.attachLifeObserver(lifeDisplayer);
        
        distance=30;
        labelObj=new Label(""+distance);
        labelObj.setText(""+distance, 40);
        addObject(labelObj,500,getHeight()-100);
        
        target=new FinishPost();
        
       
          
    }
    
    public void act()
    {
        super.act();
        if(level==2)
        {
            levelFlag=2;
            istate = new LevelTwoState();
            level=0;
            charlieimages = istate.changeCharlie();
            charlie=new Charlie(charlieimages);
            
            charlieSmallJump=220;
            charlieLongJump=200;
            charlielevel=270;
            targetlevel=270;
            this.addObject(charlie,150,charlielevel);
            charlieJumpImage="13.png";
            bckgrndimage=bckgrndimage2 = istate.changeBG();
            
             levelhurdleHeight=280;
             
             charlie.attachObserver(scoreDisplayer);
             charlie.attachLifeObserver(lifeDisplayer);
            distance=50;
        }
        
        if(levelFlag==1)
        {
           levelOneFactory = new LevelOneFactory();
           ihurdle=levelOneFactory.createHurdle(Greenfoot.getRandomNumber(2));
            
        }
        else
        {
            levelTwoFactory = new LevelTwoFactory();
            ihurdle=levelTwoFactory.createHurdle(Greenfoot.getRandomNumber(2));
        }
        
        if(x%400==0 && x!=0 && distance !=0)
            addObject((Actor)ihurdle,getWidth(),levelhurdleHeight);
        
        if(x%400==0 && x!=0 && distance !=0 && (ihurdle instanceof FireBar)) {
            ihurdle=levelOneFactory.createHurdle(1);
            addObject((Actor)ihurdle,getWidth(),levelhurdleHeight-200);
        }
        if(x%800==0 && x!=0 && distance!=0){
            distance=distance-10;
           
            labelObj.setText(""+distance, 40);
        }
        if(charlie.finishFlag){
            Greenfoot.delay(4);
            level=2;
            charlie.finishFlag=false;
            this.removeObject(charlie);
            this.removeObject(target);
            if(levelFlag==2){
                
                StateManager stateManager = StateManager.getInstance();
                stateManager.changeWorld();

            }
            
        }
        
        if(distance!=0){
             this.scroll();  
        }
        if(distance==0){
            
            if(level==0){
                addObject(target,900,targetlevel);
            }
            charlie.dettachObserver(scoreDisplayer);
        }
        
        if (!isConnected())
            return;
        
        UserData[] us = getTrackedUsers();
        
        
        boolean anyLeftHandUp = false;
        
        for (UserData u: us)
        {
           
            
            anyLeftHandUp = anyLeftHandUp || (u.getJoint(Joint.LEFT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }
        
               
        if (anyLeftHandUp)
        {
            if (leftHandUp == -1)
            {
                leftHandUp = System.currentTimeMillis();
            }
            else
            {
                if (System.currentTimeMillis() - leftHandUp > 5000 && leftHandWarning == null)
                {
                    leftHandWarning = new Label("Put your left hand down to bring down Charlie", 40);
                    addObject(leftHandWarning, getWidth() / 2, getHeight() / 2);
                }
            }
        }
        else
        {
            leftHandUp = -1;
            if (leftHandWarning != null)
            {
                removeObject(leftHandWarning);
                leftHandWarning = null;
            }
        }
    }
    
    public void scroll()
    {
        getBackground().drawImage(bckgrndimage,x,0);
        x-=10;
        if(x == -500)
            x2 = 1000;
        if(x < -500)
        {
            getBackground().drawImage(bckgrndimage2,x2,0);
            x2-=10;
        }
        if(x == -1500)
            x = 0;
    }
    
   
}
