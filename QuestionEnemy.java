import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class QuestionEnemy here.
 * 
 * David Lin (your name) 
 * 8/1/2026 (a version number or a date)
 */
public class QuestionEnemy extends Enemy
{
    /**
     * Act - do whatever the QuestionEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public QuestionEnemy() {
        super("QuestionEnemy");
        String[][] qBank = {{"What is 5+6","5","3","11a3","12"},{"What is 50*3","500","150a2","120","149"},{"What is 10+4","14a1","2","104","9"}};
        if (MyWorld.getWorldQuestionNumber() >=3) {
            MyWorld.setWorldQuestionNumber(0);
        }
        MyWorld.QEQuestion = qBank[MyWorld.getWorldQuestionNumber()][0];
        MyWorld.QEAnswer1 = qBank[MyWorld.getWorldQuestionNumber()][1];
        MyWorld.QEAnswer2 = qBank[MyWorld.getWorldQuestionNumber()][2];
        MyWorld.QEAnswer3 = qBank[MyWorld.getWorldQuestionNumber()][3];
        MyWorld.QEAnswer4 = qBank[MyWorld.getWorldQuestionNumber()][4];
        
        
        MyWorld.setWorldQuestionNumber(MyWorld.getWorldQuestionNumber()+1);
    }
    @Override
    public void act()
    {
        // Add your action code here.
        super.act();
        if (!MyWorld.questionOnScreen) {
            shootSound.setVolume(0);
            kill.setVolume(80);
            kill.play();
            getWorld().removeObject(this);
        }
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
