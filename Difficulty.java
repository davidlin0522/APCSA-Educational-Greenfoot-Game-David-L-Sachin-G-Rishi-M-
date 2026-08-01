import java.lang.*;
import greenfoot.*;
public class Difficulty extends Actor
{
    private Font font;
    private GreenfootImage img;
    public static String difficulty;
    GreenfootSound click=new GreenfootSound("button.mp3");
    public Difficulty(String text, int size){
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
        if(Greenfoot.mouseClicked(this)&&Enemy.difficutly==1){
            Enemy.lastDifficutly=2;
            click.setVolume(80);
            click.play();
        }
        else if(Greenfoot.mouseClicked(this)&&Enemy.difficutly==2){
            Enemy.lastDifficutly=3;
            click.setVolume(80);
            click.play();
        }
        else if(Greenfoot.mouseClicked(this)&&Enemy.difficutly==3){
            Enemy.lastDifficutly=4;
            click.setVolume(80);
            click.play();
        }
        else if(Greenfoot.mouseClicked(this)&&Enemy.difficutly==4){
            Enemy.lastDifficutly=1;
            click.setVolume(80);
            click.play();
        }
        if(Enemy.lastDifficutly!=0){
            Enemy.difficutly=Enemy.lastDifficutly;
        }
        else{
            Enemy.difficutly=1;
        }
        if(Enemy.difficutly==1){
            difficulty="Easy";
        }
        if(Enemy.difficutly==2){
            difficulty="Medium";
        }
        if(Enemy.difficutly==3){
            difficulty="Hard";
        }
        if(Enemy.difficutly==4){
            difficulty="Impossible";
        }
        if(MyWorld.Phase.equals("Starting")){
            getWorld().removeObject(this);
        }
        if(MyWorld.Phase.equals("Lobby")){
            if(difficulty.equals("Easy")){
                setLocation(1190,58);
            }
            if(difficulty.equals("Medium")){
                setLocation(1169,58);
            }
            if(difficulty.equals("Hard")){
                setLocation(1187,58);
            }
            if(difficulty.equals("Impossible")){
                setLocation(1141,58);
            }
        }
        update(difficulty);
    }
}