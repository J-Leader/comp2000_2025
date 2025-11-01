import java.awt.Color;

public class Lake extends Cell{
    
public Lake(char inCol, int inRow, int xPos, int yPos) // re-use given cell constructor
{
super(inCol, inRow, xPos, yPos);
cellColor = Color.CYAN;
cellAltitude = -15;
}

}
