import greenfoot.*;
public class lifeBackground extends Actor
{
    public lifeBackground(){
        GreenfootImage img = getImage();
        img.scale(162,45);
    }
    public void act()
    {
        if(MyWorld.Phase.equals("Lobby")){
            getWorld().removeObject(this);
        }        
    }
}