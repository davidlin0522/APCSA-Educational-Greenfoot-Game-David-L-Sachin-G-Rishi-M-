import greenfoot.*;
public class Quit extends Actor
{
    GreenfootSound click=new GreenfootSound("button.mp3");
    GreenfootSound quitSound = new GreenfootSound("quit.mp3");
    public Quit(){
        GreenfootImage img = getImage();
        //img.scale(109,45);
        img.scale(164,68);
    }
    public void act()
    {
        if((MyWorld.Phase.equals("Lobby"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Game"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Starting"))){
            getWorld().removeObject(this);
        }
        if((MyWorld.Phase.equals("Defeat"))){
            getWorld().removeObject(this);
        }
        if(Greenfoot.mouseClicked(this)){
            MyWorld.Phase="Defeat";
            quitSound.setVolume(80);
            quitSound.play();
            click.setVolume(80);
            click.play();
            getWorld().removeObject(this);
        }
    }
}