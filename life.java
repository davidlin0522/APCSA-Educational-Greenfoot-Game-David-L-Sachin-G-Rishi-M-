import greenfoot.*;
public class life extends Actor
{
    public int number;
    public life(int number){
        GreenfootImage img = getImage();
        img.scale(27,27);
        this.number=number;
    }
    public void act()
    {
        if(this.number==Player.lifes){
            getWorld().removeObject(this);
        }
        if(MyWorld.Phase.equals("Defeat")){
            try{
                getWorld().removeObject(this);
            }
            catch(Exception y){
                
            }
        }
    }
}