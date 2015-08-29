import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class ScoreDisplayer extends Actor implements IObserver
{
    int score;
    public ScoreDisplayer(){
        score=0;
        setImage(new GreenfootImage("Score:0" , 40, java.awt.Color.YELLOW, new java.awt.Color(0,0,0,0)));
    }
    public void act() 
    {
        display();
       
    }  
    public void update(){
            
       this.setText("Score:"+score++);       
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
