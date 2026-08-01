import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionEnemy extends Enemy
{
    /**
     * Act - do whatever the QuestionEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public QuestionEnemy() {
        super("QuestionEnemy");
    }
    @Override
    public void act()
    {
        // Add your action code here.
        super.act();
        MyWorld.QEQuestion = "Apple";
        MyWorld.QEAnswer1 = "1";
        MyWorld.QEAnswer2 = "2";
        MyWorld.QEAnswer3 = "3         5";
        MyWorld.QEAnswer4 = "4";
        /* Original kill code: 
        if (touching!= null) {
               if(getWorld()!=null||this.name!=null){
                   if (touching.Entity.equals("Player")) {
                       getWorld().removeObject(this);
                       shootSound.setVolume(0);
                       kill.setVolume(80);
                       kill.play();
                   }
               }
           }
           */
    }
}
