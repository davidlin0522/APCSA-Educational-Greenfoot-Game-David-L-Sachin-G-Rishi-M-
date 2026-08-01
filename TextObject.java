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
        updateImage();
    }

    private void updateImage()
    {
        // Creates a GreenfootImage out of the string text
        GreenfootImage img = new GreenfootImage(text, fontSize, textColor, backgroundColor);
        setImage(img);
    }
}
