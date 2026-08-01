import greenfoot.*;
import java.lang.*;
public class DifficultyBackground extends Actor
{
    public DifficultyBackground(){
        GreenfootImage img = getImage();
        img.scale(187,45);
    }
    public void act()
    {
        if(MyWorld.Phase.equals("Starting")){
            getWorld().removeObject(this);
        }
        if(MyWorld.Phase.equals("Lobby")){
            setLocation(1083,50);
        }
    }
}