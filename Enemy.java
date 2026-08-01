import greenfoot.*;
import java.lang.*;
public class Enemy extends Actor
{
    public int animation;
    public String name;
    public boolean transparent;
    public static boolean clicked;
    public int x;
    public int shootCounter=0;
    public int disapearCounter;
    public static int enemyCount;
    public static int difficutly;
    public static int lastDifficutly;
    GreenfootSound kill=new GreenfootSound("kill.mp3");
    GreenfootSound shootSound=new GreenfootSound("shoot.mp3");
    public Enemy(String name)
    {
        if(name.equals("Enemy1")){
            setImage("Enemy11.png");
            this.x=x;
        }
        else if(name.equals("Enemy2")){
            setImage("Enemy21.png");
            this.x=x;
        }
        else if(name.equals("Enemy3")){
            setImage("Enemy31.png");
            this.x=x;
        } else if(name.equals("QuestionEnemy")){
            setImage("QuestionEnemy.png");
        }
        GreenfootImage img = getImage();
        img.scale(80,40);
        setRotation(270);
        this.name=name;
        clicked=false;
        this.shootCounter=shootCounter;
    }
    public Enemy(boolean tansparent){
        GreenfootImage dummy = getImage();
        dummy.scale(1,1);
        dummy.setTransparency(0);
        setLocation(0,0);
        this.transparent=transparent;
    }
    public void act()
    {
       if(MyWorld.Phase.equals("Defeat")){
           disapearCounter++;
       }
       if(difficutly==1){
           enemyCount=1;
       }
       if(difficutly==2){
           enemyCount=2;
       }
       if(difficutly==3){
           enemyCount=3;
       }
       if(difficutly==4){
           enemyCount=4;
       }
       if(disapearCounter==60&&this.name!=null){
           getWorld().removeObject(this);
       }
       if(disapearCounter==65){
           disapearCounter=0;
           MyWorld.Phase="Lobby";
           MyWorld.reset();
       }
       if(MyWorld.Phase.equals("Game")){
           animation++;
           this.shootCounter++;
           x=getX();
           shoot touching = (shoot) getOneIntersectingObject(shoot.class);
           if (touching!= null) {
               if(getWorld()!=null||this.name!=null){
                   if (touching.Entity.equals("Player")) {
                       if (!name.equals("QuestionEnemy")){
                           getWorld().removeObject(this);
                           shootSound.setVolume(0);
                           kill.setVolume(80);
                           kill.play();
                    
                       }
                       
                       
                   }
               }
           }
           if((getWorld()!=null&&this.name!=null)&&!this.transparent){
               if((this.shootCounter==81&&difficutly==1)||(this.shootCounter==61&&difficutly==2)||(this.shootCounter==41&&difficutly==3)||(this.shootCounter==11&&difficutly==4)){
                   MyWorld.yEnemyShoot=getY();
                   MyWorld.nameEnemyShoot=this.name;
                   MyWorld.enemyShoot=true;
                   this.shootCounter=0;
                   this.shootSound.setVolume(75);
                   this.shootSound.play();
                   /*System.out.println("ShootSound von: " + this + 
                       " | name=" + name + 
                       " | x=" + getX() + 
                       " | transparent=" + transparent + 
                       " | shootCounter=" + shootCounter);*/
               }
           }
           if(animation==22&&name=="Enemy1"){
               setImage("Enemy12.png");
               GreenfootImage img = getImage();
               img.scale(80,40);
           }
           else if(animation==42&&name=="Enemy1"){
               setImage("Enemy11.png");
               GreenfootImage img = getImage();
               img.scale(80,40);
               animation=0;
           }
           if(animation==25&&name=="Enemy2"){
               setImage("Enemy22.png");
               GreenfootImage img = getImage();
               img.scale(80,40);
           }
           else if(animation==45&&name=="Enemy2"){
               setImage("Enemy21.png");
               GreenfootImage img = getImage();
               img.scale(80,40);
               animation=0;
           }
           if(animation==28&&name=="Enemy3"){
               setImage("Enemy32.png");
               GreenfootImage img = getImage();
               img.scale(80,40);
           }
           else if(animation==48&&name=="Enemy3"){
               setImage("Enemy31.png");
               GreenfootImage img = getImage();
               img.scale(80,40);
               animation=0;
           }
           if(MyWorld.Phase.equals("Game")&&!(MyWorld.anzahl==enemyCount)&&(MyWorld.counter==1)&&!(MyWorld.spawnEnemy)){
               MyWorld.spawnEnemy=true;
           }
           if(Greenfoot.mouseClicked(this)){
               clicked=true;
           }
           try{
               if(getX()==1149){}
               else{
                   this.x-=10;
                   setLocation(this.x,getY());
               }
           }
           catch(Exception c){}
       }
       if(MyWorld.Phase.equals("Starting")){
           lastDifficutly=difficutly;
       }
       if(this.transparent){
           this.shootSound.setVolume(0);
       }
    }
}