import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor{
  Color color;
  Cell loc;
  List<Polygon> display;
  List<String> movementTemplate; // used in subclasses to define the names of Cells the Actor can step into
  List<Cell> passableCellsList; //final list of cells the actor can step into, to be checked against when movement is implemented.
  List<Cell> MoveableCells;

  public Actor(Cell inLoc){
    loc = inLoc;
    display = new ArrayList<>();
    movementTemplate = new ArrayList<>();
    passableCellsList = new ArrayList<>();
    MoveableCells = new ArrayList<>();
  }


  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  public List<Cell> findPassableCells(Grid grid)
  {
    for(int i=0; i<grid.cells.length; i++) 
    {
      for(int j=0; j<grid.cells[i].length; j++) 
      {
        Class currentCellType = grid.cells[i][j].getClass();
        String currentCellTypeName = currentCellType.getName();
        for(int k=0; k<movementTemplate.size();k++)
        {
          if(currentCellTypeName==movementTemplate.get(k))
          {
            passableCellsList.add(grid.cells[i][j]);
          }
          
        }
      }
    }

    return passableCellsList;
  }

}
