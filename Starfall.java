import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Starfall extends Actor
{
    public Starfall(){
        GreenfootImage img = getImage();
        img.scale(700,133);
    }
    public void act()
    {
        if((MyWorld.Phase=="Starting")&&!(getY()==0)){
            setRotation(270);
            move(4);
            setRotation(0);
        }
        else if(getY()==0){
            getWorld().removeObject(this);
        }
    }
}