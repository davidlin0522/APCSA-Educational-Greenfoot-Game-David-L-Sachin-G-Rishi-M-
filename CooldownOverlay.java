import greenfoot.*;

public class CooldownOverlay extends Actor
{   
    public static boolean cooldown;
    public static boolean cooldownGo;
    private GreenfootImage baseImg;
    private GreenfootImage cooldownimg;
    private int Y;
    private int height;
    public static boolean shooting;
    public int counter;
    public CooldownOverlay(){
        baseImg = new GreenfootImage("Cooldown Overlay.png");
        Y=48;
        height=42;
        cooldownimg = new GreenfootImage(baseImg);
        cooldownimg.scale(45, height);
        cooldownimg.setTransparency(0);
        setImage(cooldownimg);
    }
    public void cooldown(){
        baseImg = new GreenfootImage("Cooldown Overlay.png");
        cooldown = true;
        Y=48;
        height = 41;
        cooldownimg = new GreenfootImage(baseImg);
        cooldownimg.scale(45, height);
        cooldownimg.setTransparency(0);
        setImage(cooldownimg);
    }
    public void act()
    {
        if(MyWorld.Phase.equals("Lobby")){
            getWorld().removeObject(this);
        }
        if(cooldownGo){
            cooldownGo = false;
            cooldown = true;
            counter=0;
            Y=48;
            setLocation(60,50);
            height = 41;
        }
        if(cooldown){   
            if(height > 1 && MyWorld.Phase.equals("Game")){
                height--;
                Y++;
                counter++;
                if(counter==2){
                    Y--;
                    counter=0;
                }
            } 
            setLocation(60,Y);
            cooldownimg = new GreenfootImage(baseImg);
            cooldownimg.scale(41, height);
            cooldownimg.setTransparency(255);
            setImage(cooldownimg);
            shooting=false;
            if(height==1){
                cooldown = false;
                shooting=true;
                cooldownimg.setTransparency(0);
                counter=0;
                height = 41;
                Y=48;
                setLocation(60,50);
                cooldownimg.scale(41, height);
                setImage(cooldownimg);
            }
        }
    }
}
