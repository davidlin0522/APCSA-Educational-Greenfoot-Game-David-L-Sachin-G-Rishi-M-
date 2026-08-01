import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class ScoreBackground extends Actor
{
    public ScoreBackground(){
        GreenfootImage img = getImage();
        img.scale(180,45);
    }
    public void act()
    {
        if(MyWorld.Phase.equals("Starting")&&(182>getX())){
            setRotation(0);
            move(3);
            setRotation(0);
        }
        if(MyWorld.Phase.equals("Game")){
            setLocation(182,50);
        }
        if(MyWorld.Phase.equals("Lobby")){
            setLocation(125,50);
        }
    }
}