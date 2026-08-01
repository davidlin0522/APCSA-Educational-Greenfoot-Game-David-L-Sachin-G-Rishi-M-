import greenfoot.*;
public class Resume extends Actor
{
    GreenfootSound click=new GreenfootSound("button.mp3");
    public Resume(){
        GreenfootImage img = getImage();
        //img.scale(48,45);
        img.scale(72,68);
    }
    public void act()
    {
        if((MyWorld.Phase.equals("Lobby"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Starting"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Game"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Defeat"))){
            getWorld().removeObject(this);
        }
        if(Greenfoot.mouseClicked(this)){
            MyWorld.Phase="Game";
            click.setVolume(80);
            click.play();
            getWorld().removeObject(this);
            MyWorld.menüExit=true;
        }
    }
}