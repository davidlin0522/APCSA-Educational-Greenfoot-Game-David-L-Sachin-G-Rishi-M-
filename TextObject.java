import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestQuestion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;

public class TextObject extends Actor
{
    private String text;
    private int fontSize;
    private Color textColor;
    private Color backgroundColor;

    public TextObject(String text, int fontSize, Color textColor)
    {
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.backgroundColor = new Color(0, 0, 0, 0);
        
        updateImage();
    }
    public void act(){
        
    }
    // Method to change text dynamically (e.g. updating a score or question)
    public void setText(String newText)
    {
        this.text = newText;
        if (newText.length() >= 3) {
            if (newText.charAt(newText.length()-2) == 'a') {
                this.text = newText.substring(0,newText.length()-2);
                if (Greenfoot.isKeyDown(String.valueOf(newText.charAt(newText.length() - 1)))){
                    MyWorld.questionOnScreen = false;
                    System.out.println("answered question!");
                    
                    resetText();

                    MyWorld.spawnEnemy = true;

                }
        }}
        
        updateImage();
        
}

private void updateImage()
{
    // Creates a GreenfootImage out of the string text
    GreenfootImage img = new GreenfootImage(text, fontSize, textColor, backgroundColor);
    setImage(img);
}
public static void resetText() {  // Static method
    MyWorld.QEQuestion = "";
    MyWorld.QEAnswer1 = "";
    MyWorld.QEAnswer2 = "";
    MyWorld.QEAnswer3 = "";
    MyWorld.QEAnswer4 = "";
}
}
