import greenfoot.*;
public class Menü extends Actor
{
    GreenfootSound click=new GreenfootSound("button.mp3");
    public Menü(){
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
        if(Greenfoot.mouseClicked(this)){
            MyWorld.Phase="Menü";
            click.setVolume(80);
            click.play();
            getWorld().removeObject(this);
            MyWorld.menü=true;
        }
    }
}
