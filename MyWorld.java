import lang.stride.*;
import java.lang.*;
import greenfoot.*;
import greenfoot.GreenfootSound;
import java.io.*;

/*made by Lero319/Leonard Rohatsch*/

public class MyWorld extends World
{
    public static String Phase;
    public static String enemy;
    public static boolean start;
    public static boolean menü;
    public static boolean menüExit;
    public static boolean spawnEnemy;
    public static int random;
    public static int anzahl;
    public static int counter;
    public static int y;
    public static int score;
    public static int yEnemyShoot;
    public static String nameEnemyShoot;
    public static boolean enemyShoot;
    public static boolean started;
    public static int spawnDelay;
    public static boolean mute=false;
    GreenfootSound music=new GreenfootSound("music.mp3");
    GreenfootSound playerShoot = new GreenfootSound("shoot.mp3");
    public MyWorld()
    {    
        super(1200, 600, 1); 
        prepare();
    }
    
    public void prepare()
    {
        addObject(new Enemy(true),0,0);
        addObject(new Player(true), 600, 295);
        addObject(new Starfall(), 600, 100);
        addObject(new Start(true), 600, 500);
        addObject(new ScoreBackground(),125,50);
        addObject(new Score("Score: ", 20),188,58);
        addObject(new DifficultyBackground(),1083,50);
        addObject(new Difficulty("Difficulty",20),1148,58);
        addObject(new Mute(mute, true),1100,500);
        loadDifficutly();
        enemyShoot=false;
        Phase = "Lobby";
        anzahl=0;
        started=false;
        counter=0;
        nameEnemyShoot="Dummy";
        spawnEnemy=false;
        shoot.playerShooting=false;
        CooldownOverlay.cooldown=false;
        start=false;
        menü=false;
        CooldownOverlay.shooting=true;
        score=0;

        //debug-features:
        //addObject(new Anzahl("Anzahl",20),1100,100);
        //addObject(new Counter("Counter",20),1100,120);
    }
    public static void reset(){
        enemyShoot=false;
        anzahl=0;
        counter=0;
        nameEnemyShoot="Dummy";
        spawnEnemy=false;
        shoot.playerShooting=false;
        CooldownOverlay.cooldown=false;
        start=false;
        started=false;
        menü=false;
        CooldownOverlay.shooting=true;
    }
    public void act(){
       music.playLoop();
       if(mute){
           music.setVolume(0);
       }
       else{
           music.setVolume(35);
       }
       if(Phase.equals("Menü")){
           addObject(new MenüBackground(),600,300);
           addObject(new MenüSchrift("Menu", 40),660,170);
           addObject(new Quit(),600,380);
           addObject(new Resume(),645,300);
           addObject(new Mute(mute),554,300);
       }
       if(Enemy.difficutly==1){
           spawnDelay=120;
       }
       if(Enemy.difficutly==2){
           spawnDelay=90;
       }
       if(Enemy.difficutly==3){
           spawnDelay=60;
       }
       if(Enemy.difficutly==4){
           spawnDelay=45;
       }
       if(CooldownOverlay.shooting&&Phase.equals("Game")&&(Greenfoot.mouseClicked(this)||(Enemy.clicked==true)||(shoot.clicked==true))){
           addObject(new shoot("Player"), 50, Player.Y);
           CooldownOverlay.cooldownGo=true;
           playerShoot.setVolume(75);
           playerShoot.play();
           Enemy.clicked=false;
           shoot.clicked=false;
       }
       if(start){
           start=false;
           addObject(new Cooldown(),60,50);
           addObject(new CooldownOverlay(),60,50);
           addObject(new Menü(),1140,50);
           addObject(new lifeBackground(), 361, 50);
           addObject(new life(0),299,50);
           addObject(new life(1),329,50);
           addObject(new life(2),359,50);
           addObject(new life(3),389,50);
           addObject(new life(4),419,50);
       }
       if(menü){
           menü=false;
           addObject(new MenüExit(),1140,50);
       }
       if(menüExit){
           menüExit=false;
           addObject(new Menü(),1140,50);
       }
       if(spawnEnemy){
           addObject(new Enemy(enemy),1200,y);
           spawnEnemy=false;
           anzahl++;
       }
       if(counter==spawnDelay){
           counter=0;
       }
       if(Phase.equals("Game")){
           counter++;
       }
       if(Phase.equals("Lobby")&&!started){
           addObject(new Starfall(), 600, 100);
           addObject(new Player(), 600, 295);
           addObject(new Start(), 600, 500);
           addObject(new DifficultyBackground(),1083,50);
           addObject(new Difficulty("Difficulty",20),1148,58);
           addObject(new Mute(mute, true),1100,500);
           started=true;
       }
       if(Phase.equals("Starting")){
           score=0;
       }
       random=4-Greenfoot.getRandomNumber(4);
       y=540-Greenfoot.getRandomNumber(420);
       if(random==1){
           enemy="Enemy1";
       }
       if(random==2){
           enemy="Enemy2";
       }
       if(random==3){
           enemy="Enemy3";
       }
       if(anzahl==3){
           spawnEnemy=false;
       }
       if(enemyShoot){
           addObject(new shoot(nameEnemyShoot),1149,yEnemyShoot);
           enemyShoot=false;
       }
    }
    public static void spawnEnemy(){
        spawnEnemy=false;
    }
    public static void loadDifficutly() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("lastDifficulty.txt"));
            String line = reader.readLine();
            if (line != null) {
                Enemy.lastDifficutly = Integer.parseInt(line);
            }
            reader.close();
        } catch (Exception e) {
            Enemy.lastDifficutly = 0;
        }
    }
    public static void saveDifficutly() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("lastDifficulty.txt"));
            writer.write(Integer.toString(Enemy.lastDifficutly));
            writer.close();
        } catch (Exception e) {
            System.out.println("Konnte Difficulty nicht speichern.");
        }
    }
}