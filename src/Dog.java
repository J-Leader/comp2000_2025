import java.awt.Color;
import java.awt.Polygon;

public class Dog extends Actor  {
  public Dog(Cell inLoc) {
    super(inLoc);
    color = Color.YELLOW;
    possibleMovementTemplate.add("Grass");
    possibleMovementTemplate.add("Lake");
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 20, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 8, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 25);
    face.addPoint(loc.x + 8, loc.y + 25);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
  }

   public void onHovered()
  {
    System.out.println("Woof");
  }

  public void offHovered()
  {
    System.out.println("Wait come back!");
  }
}
