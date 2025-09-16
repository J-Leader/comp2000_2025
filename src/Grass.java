
import java.awt.Color;

public class Grass extends Cell{

    //grass is basic tile and goes everywhere that isn't lake or shore
    
public Grass (char inCol, int inRow, int xPos, int yPos) 
{
super(inCol, inRow, xPos, yPos); //Super Cell constructor to ensure that col and row values are set and rectangle super is also used.
cellColor = Color.GREEN;
}

}
