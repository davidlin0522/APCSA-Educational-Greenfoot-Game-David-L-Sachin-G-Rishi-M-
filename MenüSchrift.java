import greenfoot.*;
import java.lang.*;
public class MenüSchrift extends Actor
{
    private Font font;
    private GreenfootImage img;
    public MenüSchrift(String text, int size){
        font = new Font("Ethnocentric", size);
        img = new GreenfootImage(300, size + 20);
        img.setFont(font);
        setImage(img);
        update(text);
    }
    public void update(String newText){
        img.clear();
        img.setColor(new Color(0,186,255));
        img.drawString(newText, 5, font.getSize());
    }
    public void act(){
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
    }
}