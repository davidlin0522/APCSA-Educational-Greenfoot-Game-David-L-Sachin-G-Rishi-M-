import greenfoot.*;
public class Start extends Actor
{
    public boolean Dummy;
    GreenfootSound click=new GreenfootSound("button.mp3");
    public Start(){
        GreenfootImage img = getImage();
    }
    public Start(boolean Dummy){
        this.Dummy=Dummy;
    }
    public void act()
    {
        if((MyWorld.Phase=="Lobby")&&(Greenfoot.mouseClicked(this))){
            MyWorld.Phase="Starting";
            click.setVolume(80);
            click.play();
            MyWorld.saveDifficutly();
        }
        if((MyWorld.Phase=="Starting")&&!(getY()==599)){
            setRotation(90);
            move(4);
            setRotation(0);
        }
        else if(getY()==599){
            getWorld().removeObject(this);
        }
        if(this.Dummy){
            getWorld().removeObject(this);
        }
    }
}