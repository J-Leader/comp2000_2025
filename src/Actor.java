import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements animalBehaviour{
  Color color;
  Cell loc;
  List<Polygon> display;
  List<String> possibleMovementTemplate; // used in subclasses to define the names of Cells the Actor can step into
  List<Cell> passableCellsList; //final list of cells the actor can step into, to be checked against when movement is implemented.
  List<Cell> MoveableCells;
  boolean madeSound;


  public Actor(Cell inLoc){
    loc = inLoc;
    display = new ArrayList<>();
    possibleMovementTemplate = new ArrayList<>();
    passableCellsList = new ArrayList<>();
    MoveableCells = new ArrayList<>();
    
  }


  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
      this.isHovered();
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
        for(int k=0; k<possibleMovementTemplate.size();k++)
        {
          if(currentCellTypeName==possibleMovementTemplate.get(k))
          {
            passableCellsList.add(grid.cells[i][j]);
          }
          
        }
      }
    }

    return passableCellsList;
  }

 public void isHovered()
  {
    if(loc.hovered && !madeSound)
    {
      this.onHovered();
      madeSound=true;
    }
    else if(!loc.hovered && madeSound)
    {
      madeSound=false;
      this.offHovered();
    }
    
    
  }

}
