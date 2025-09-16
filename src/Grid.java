import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;
import java.util.Random; //used to add randomisation to map generation


public class Grid {
  Cell[][] cells = new Cell[20][20];
  Random rand = new Random();
  public Grid() { //changed cell to Grass
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
         int randomSpawnValue = rand.nextInt(15);
        switch(randomSpawnValue)
        {
          case 1:
          cells[i][j] = new Lake(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j);
          break;
          case 3:
          cells[i][j] = new Mountain(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j);
          break;
          default:
          cells[i][j] = new Grass(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j);
          break;
        }
      }
    }
  }



  private char colToLabel(int col) {
    return (char) (col + Character.valueOf('A'));
  }

  private int labelToCol(char col) {
    return (int) (col - Character.valueOf('A'));
  }

  public void paint(Graphics g, Point mousePos) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }

  public Optional<Cell> cellAtColRow(int c, int r) {
    if(c >= 0 && c < cells.length && r >=0 && r < cells[c].length) {
      return Optional.of(cells[c][r]);
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cell> cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for(int i=0; i < cells.length; i++) {
      for(int j=0; j < cells[i].length; j++) {
        if(cells[i][j].contains(p)) {
          return Optional.of(cells[i][j]);
        }
      }
    }
    return Optional.empty();
  }
}
