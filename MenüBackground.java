import greenfoot.*;
public class MenüBackground extends Actor
{
    public MenüBackground(){
        GreenfootImage img=getImage();
        img.scale(300,450);
    }
    public void act()
    {
        if(!MyWorld.Phase.equals("Menü")){
            getWorld().removeObject(this);
        }
    }
}