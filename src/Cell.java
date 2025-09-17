import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Cell extends Rectangle { //made abstract to ensure that all cells are either lake, shore or grass
  static int size = 35;
  char col;
  int row;
  Color cellColor; // variable inherited and used by Cell variants to differentiate
  int cellAltitude; // variable that could be used to check for events such as strong weather. e.g strong winds hitting harder if you're up high on a mountain vs on level ground in the grass.  
  //List<Items> spawnableItems; //to be a list of items that a cell can spawn. 



  public Cell(char inCol, int inRow, int x, int y) {
    super(x, y, size, size);
    col = inCol;
    row = inRow;
  }

  public void paint(Graphics g, Point mousePos) {
    if(contains(mousePos)) {
      g.setColor(Color.GRAY);
    } else {
      g.setColor(cellColor);
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
}
