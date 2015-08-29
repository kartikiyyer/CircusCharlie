import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class LifeDisplayer extends Actor implements ILifeObserver
{
   int life;
   GreenfootSound sound;
    public LifeDisplayer(GreenfootSound sound){
        life=3;
        setImage(new GreenfootImage("Life:3" , 40, java.awt.Color.YELLOW, new java.awt.Color(0,0,0,0)));
        this.sound=sound;
    }
    public void act() 
    {
        display();
        if(life==0){
            setImage(new GreenfootImage("GAME OVER" , 80, java.awt.Color.YELLOW, new java.awt.Color(0,0,0,0)));
            Greenfoot.delay(4);
            
            StateManager stateManager = StateManager.getInstance();
            stateManager.changeWorld();

            sound.stop();
        }
        
    }  
    public void update(){
     
       
       this.setText("Life:"+(--life));
       
    }
    public void display(){
        
    }
    public void setText(String text)
    {
        setText(text, 40);
    }
    public void setText(String text, int size)
    {
        setImage(new GreenfootImage(text , size, java.awt.Color.YELLOW, new java.awt.Color(0,0,0,0)));
    }
}
