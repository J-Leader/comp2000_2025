import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Cell extends Rectangle {
  static int size = 35;
  char col;
  int row;

  Color cellColor; // variable inherited and used by Cell variants to differentiate
  int cellAltitude; // variable that could be used to check for events such as strong weather. e.g strong winds hitting harder if you're up high on a mountain vs on level ground in the grass.  
  //List<Items> spawnableItems; //to be a list of items that a cell can spawn. 
  boolean hovered;

  int weatherState; // int tracking weather state

  public Cell(char inCol, int inRow, int x, int y) {
    super(x, y, size, size);
    col = inCol;
    row = inRow;
    weatherState = 0; // sets initial weather state to clear
  }

   public void paint(Graphics g, Point mousePos) {
    if(contains(mousePos)) {
      g.setColor(Color.GRAY);
      this.hovered = true;
      //System.out.println(hovered);
    } else {
      g.setColor(cellColor);
      this.hovered = false;
      //System.out.println(hovered);
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }


  @Override
  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }

  public int leftOfComparison(Cell c) {
    return Integer.compare(col, c.col);
  }

  public int aboveComparison(Cell c) {
    return Integer.compare(row, c.row);
  }

  //state machine to be done

  
}
  