import greenfoot.*;
import java.lang.*;
public class shoot extends Actor
{
    public String Entity;
    public static boolean playerShooting;
    public static boolean enemyShooting;
    public boolean touching;
    public static int inRange;
    public static int range;
    public static int shootSpeed;
    public static boolean clicked;
    GreenfootSound hitSound = new GreenfootSound("hitNew.mp3");
    public shoot(String Entity){
        this.Entity=Entity;
        if(Entity!=null){
            if(Entity.equals("Player")){
                setRotation(90);
                setImage("Shoot Player.png");
                GreenfootImage img=getImage();
                img.scale(80, 40);
                playerShooting=true;
                range=92;
                setImage(img);
            }
            if(Entity.equals("Enemy1")){
                setRotation(270);
                setImage("Shoot Enemy1.png");
                GreenfootImage img=getImage();
                img.scale(80, 40);
                enemyShooting=true;
                setImage(img);
            }
            else if(Entity.equals("Enemy2")){
                setRotation(270);
                setImage("Shoot Enemy2.png");
                GreenfootImage img=getImage();
                img.scale(80, 40);
                enemyShooting=true;
                setImage(img);
            }
            else if(Entity.equals("Enemy3")){
                setRotation(270);
                setImage("Shoot Enemy3.png");
                GreenfootImage img=getImage();
                img.scale(80, 40);
                enemyShooting=true;
                setImage(img);
            }
            else if(Entity.equals("Dummy")){
                GreenfootImage img=getImage();
                img.setTransparency(0);
                img.scale(1,1);
                setLocation(0,0);
                setImage(img);
            }
        }
        else{
            GreenfootImage img=(new GreenfootImage("board.jpg"));
            img.setTransparency(0);
            setImage(img);
        }
    }
    public void act()
    {
        if(this.Entity!=null){
            if(MyWorld.Phase.equals("Game")||(MyWorld.Phase.equals("Defeat"))){
                if(playerShooting&&(this.Entity.equals("Player"))){
                    if(getObjectsInRange(range,Enemy.class).size()==1){
                        inRange=1;
                    }
                    if(getObjectsInRange(range,Enemy.class).size()==2){
                        inRange=2;
                    }
                    if(getObjectsInRange(range,Enemy.class).size()==3){
                        inRange=3;
                    }
                        if(getObjectsInRange(range,Enemy.class).size()==4){
                        inRange=4;
                    }
                    if(getObjectsInRange(range,Enemy.class).isEmpty()){
                        inRange=0;
                    }
                    if(!(getX()==1200)){
                        setRotation(0);
                        move(25);
                        setRotation(90);
                    }
                    else if(!isTouching(Enemy.class)){
                        setRotation(0);
                        move(25);
                        setRotation(90);
                    }
                    else{
                        getWorld().removeObject(this);
                    }
                    if(isTouching(Enemy.class)&&!touching){
                        GreenfootImage gone=getImage();
                        gone.setTransparency(0);
                        MyWorld.anzahl-=inRange;
                        MyWorld.score++;
                    }
                    if(isTouching(Enemy.class)){
                        touching=true;
                    }
                    else{
                        touching=false;
                    }
                    if(getX()>1190){
                        getWorld().removeObject(this);
                    }
                }
                if(enemyShooting&&!(this.Entity.equals("Player"))){
                    if(getObjectsInRange(range,Player.class).size()==1){
                       inRange=1;
                    }
                    if(!(getX()==0)){
                        setRotation(180);
                        move(shootSpeed);
                        setRotation(270);
                    }
                    else if(!isTouching(Enemy.class)){
                       setRotation(180);
                        move(shootSpeed);
                        setRotation(270);
                    }
                    else{
                        getWorld().removeObject(this);
                    }
                    if(isTouching(Player.class)&&!touching){
                        GreenfootImage gone=getImage();
                        gone.setTransparency(0);
                        Player.lifes--;
                        hitSound.setVolume(76);
                        hitSound.play();
                    }
                    if(isTouching(Player.class)){
                        touching=true;
                    }
                    else{
                        touching=false;
                    }
                    if(10>getX()){
                        getWorld().removeObject(this);
                    }
                }
            }
        }
        if(Enemy.difficutly==1){
           shootSpeed=20;
        }
        if(Enemy.difficutly==2){
           shootSpeed=22;
        }
        if(Enemy.difficutly==3){
           shootSpeed=25;
        }
        if(Enemy.difficutly==4){
           shootSpeed=35;
        }
        if(Greenfoot.mouseClicked(this)){
               clicked=true;
           }
    }
}