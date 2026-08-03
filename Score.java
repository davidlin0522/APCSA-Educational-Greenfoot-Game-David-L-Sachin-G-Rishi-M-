import java.lang.*;
import greenfoot.*;
public class Score extends Actor
{
    private Font font;
    private GreenfootImage img;
    public Score(String text, int size){
        font = new Font("Ethnocentric", size);
        img = new GreenfootImage(300, size + 20);
        img.setFont(font);
        setImage(img);
        update(text);
    }
    public void update(String newText){
        img.clear();
        img.setColor(new Color(48,48,48));
        img.drawString(newText, 5, font.getSize());
    }
    public void act(){
        update("Score: "+ MyWorld.getScore());
        if(MyWorld.Phase.equals("Starting")&&(249>getX())){
            setRotation(0);
            move(3);
            setRotation(0);
        }
        if(MyWorld.Phase.equals("Game")){
            setLocation(249,58);
        }
        if(MyWorld.Phase.equals("Lobby")){
            setLocation(188,58);
        }
    }
}