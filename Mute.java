import greenfoot.*;
import java.lang.*;
public class Mute extends Actor
{
    GreenfootSound click=new GreenfootSound("button.mp3");
    public boolean lobby;
    public Mute(boolean muted){
        if(muted){
            GreenfootImage mutedimg = new GreenfootImage("Unmute.png");
            //mutedimg.scale(48,45);
            mutedimg.scale(72,68);
            setImage(mutedimg);
            this.lobby=false;
        }
        if(!muted){
            GreenfootImage unmutedimg = new GreenfootImage("Mute.png");
            //unmutedimg.scale(48,45);
            unmutedimg.scale(72,68);
            setImage(unmutedimg);
            this.lobby=false;
        }
    }
    public Mute(boolean muted, boolean lobby){
        if(muted){
            GreenfootImage mutedimgLobby = new GreenfootImage("Unmute.png");
            //mutedimg.scale(48,45);
            mutedimgLobby.scale(72,68);
            setImage(mutedimgLobby);
            this.lobby=lobby;
        }
        if(!muted){
            GreenfootImage unmutedimgLobby = new GreenfootImage("Mute.png");
            //unmutedimg.scale(48,45);
            unmutedimgLobby.scale(72,68);
            setImage(unmutedimgLobby);
            this.lobby=lobby;
        }
    }
    public void act()
    {
        if((MyWorld.Phase.equals("Lobby")&&!this.lobby)){
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
        if(Greenfoot.mouseClicked(this)&&MyWorld.mute&&!this.lobby){
            MyWorld.mute=false;
            click.setVolume(80);
            click.play();
            setImage("Mute.png");
        }
        else if(Greenfoot.mouseClicked(this)&&!MyWorld.mute&&!this.lobby){
            MyWorld.mute=true;
            click.setVolume(80);
            click.play();
            setImage("Unmute.png");
        }
        if(Greenfoot.mouseClicked(this)&&MyWorld.mute&&this.lobby){
            MyWorld.mute=false;
            click.setVolume(80);
            click.play();
            GreenfootImage mutedimgLobby = new GreenfootImage("Mute.png");
            mutedimgLobby.scale(72,68);
            setImage(mutedimgLobby);
        }
        else if(Greenfoot.mouseClicked(this)&&!MyWorld.mute&&this.lobby){
            MyWorld.mute=true;
            click.setVolume(80);
            click.play();
            GreenfootImage unmutedimgLobby = new GreenfootImage("Unmute.png");
            unmutedimgLobby.scale(72,68);
            setImage(unmutedimgLobby);
        }
    }
}