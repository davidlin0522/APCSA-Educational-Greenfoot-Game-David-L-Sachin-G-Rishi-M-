import greenfoot.*;
public class Cooldown extends Actor
{
    public Cooldown(){
        GreenfootImage img = getImage();
        img.scale(48,45);
    }
    public void act()
    {
        if((MyWorld.Phase.equals("Lobby"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Starting"))){
            getWorld().removeObject(this);
        }
    }
}