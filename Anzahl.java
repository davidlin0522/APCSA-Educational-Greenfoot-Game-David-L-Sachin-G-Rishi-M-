import java.lang.*;
import greenfoot.*;
public class Anzahl extends Actor
{
    private Font font;
    private GreenfootImage img;
    public Anzahl(String text, int size){
        font = new Font("Arial", size);
        img = new GreenfootImage(300, size + 20);
        img.setFont(font);
        setImage(img);
        update(text);
    }
    public void update(String newText){
        img.clear();
        img.setColor(Color.WHITE);
        img.drawString(newText, 5, font.getSize());
    }
    public void act(){
        update("Anzahl: " + MyWorld.anzahl);
    }
}