import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


public class QuestionEnemy extends Enemy
{
    /**
     * Act - do whatever the QuestionEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public QuestionEnemy() {
        super("QuestionEnemy");
        Random rand = new Random();
        String[][] qBank = new String[3][5];
        // populate qBank with random questions
        for (int i = 0; i < qBank.length; i++) {
            int num1 = rand.nextInt(10) + 1;
            int num2 = rand.nextInt(10) + 1;
            int ans = num1 + num2;
        
            qBank[i][0] = "What is " + num1 + " + " + num2;
        
            String[] answers = new String[3];
            answers[0] = Integer.toString(ans + rand.nextInt(5) + 1);
            answers[1] = Integer.toString(ans - rand.nextInt(5) - 1);
            answers[2] = Integer.toString(ans + rand.nextInt(10) + 6);
        
            int correctPos = rand.nextInt(4);
        
            int wrongIndex = 0;
            for (int j = 0; j < 4; j++) {
                if (j == correctPos) {
                    qBank[i][j + 1] = ans + "a" + (j + 1);
                } else {
                    qBank[i][j + 1] = answers[wrongIndex];
                    wrongIndex++;
                }
            }
        }
        
        
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
