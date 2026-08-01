import greenfoot.*;
import java.lang.*;
import greenfoot.GreenfootSound;
public class Player extends Actor
{
    public static int Y;
    public int animationCounter;
    public int Height;
    public int Width;
    private GreenfootImage original;
    public static int lifes;
    public boolean Dummy;
    GreenfootSound deadSound = new GreenfootSound("dead.mp3");
    public Player()
    {
        original = new GreenfootImage("Player1.png");
        GreenfootImage img = new GreenfootImage(original);
        img.scale(160,80);
        setImage(img);
        setRotation(0);
        animationCounter=0;
        Width=160;
        Height=80;
        lifes=5;
    }
    public Player(boolean Dummy){  
        this.Dummy=Dummy;
        original = new GreenfootImage("Player1.png");
        GreenfootImage img = new GreenfootImage(original);
        img.scale(160,80);
        setImage(img);
        setRotation(0);
    }
    public void act()
    {
        if(this.Dummy){
            getWorld().removeObject(this);
        }
        if(MyWorld.Phase.equals("Game")){
            try{
                Y=Greenfoot.getMouseInfo().getY();}
            catch(Exception a){
                Y=300;
            }
            GreenfootImage gamePrep = getImage();
            gamePrep.scale(80,40);
            setRotation(90);
            setLocation(50,Y);
            animationCounter++;
            if(animationCounter==20){
                GreenfootImage animation=new GreenfootImage("Player2.png");
                animation.scale(80,40);
                setImage(animation);
            }
            else if(animationCounter==40){
                GreenfootImage animation=new GreenfootImage("Player1.png");
                animation.scale(80,40);
                setImage(animation);
                animationCounter=0;
            } 
        }
        if(MyWorld.Phase.equals("Lobby")){
            animationCounter++;
            if(animationCounter==23){
                setImage("Player2.png");
                GreenfootImage img = getImage();
                img.scale(160,80);
                setRotation(0);
                setLocation(600,300);
            }
            else if(animationCounter==46){
                setImage("Player1.png");
                GreenfootImage img = getImage();
                img.scale(160,80);
                animationCounter=0;
                setRotation(0);
                setLocation(600,295);
            }
        }
        if(MyWorld.Phase.equals("Starting")){
            GreenfootImage starting = new GreenfootImage(original);
            if(!(getRotation()==90)){
                setRotation(getRotation()+3);
            }
            if(Width>80){
                Width=Width-2;
            }
            if(Height>40){
                Height--;
            }
            starting.scale(Width,Height);
            setImage(starting);
            if(!(getX()==50)){
                setLocation(getX()-10,300);
            }
            if(getX()==50&&starting.getWidth()==80&&starting.getHeight()==40&&getRotation()==90){
                MyWorld.Phase="Game";
                MyWorld.start=true;
            }
        }
        if(MyWorld.Phase.equals("Menü")){
            animationCounter++;
            if(animationCounter==20){
                GreenfootImage animation=new GreenfootImage("Player2.png");
                animation.scale(80,40);
                setImage(animation);
            }
            else if(animationCounter==40){
                GreenfootImage animation=new GreenfootImage("Player1.png");
                animation.scale(80,40);
                setImage(animation);
                animationCounter=0;
            } 
        }
        if(lifes==0){
            MyWorld.Phase="Defeat";
            GreenfootImage dead=getImage();
            dead.setTransparency(0);
            getWorld().removeObject(this);
            deadSound.setVolume(60);
            deadSound.play();
        }
        if(MyWorld.Phase.equals("Defeat")){
            try{
                getWorld().removeObject(this);
            }
            catch(Exception y){
                
            }
        }
    }
}