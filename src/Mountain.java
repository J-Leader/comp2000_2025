import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Mountain extends Cell{
    int snowOffset =5;
    
public Mountain(char inCol, int inRow, int xPos, int yPos) // re-use given cell constructor
{
super(inCol, inRow, xPos, yPos);
cellColor = Color.DARK_GRAY;
}

@Override //Overrides the inherited paint method from Cell 
  public void paint(Graphics g, Point mousePos) { 
    super.paint(g, mousePos); // Uses the super (Inherited paint method)
    g.setColor(Color.WHITE); //added on additional code executed after paint method
    g.drawOval(x+snowOffset, y+snowOffset, size-snowOffset*2, size -snowOffset*2);
    g.fillOval(x+snowOffset, y+snowOffset, size-snowOffset*2, size -snowOffset*2);
  }
}
