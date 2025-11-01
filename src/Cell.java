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

  WeatherState currentWeatherState;

  static final String rain = "rain";
  static final String temp = "temp";
  static final String windx = "windx";
  static final String windy = "windy";


  public Cell(char inCol, int inRow, int x, int y) {
    super(x, y, size, size);
    col = inCol;
    row = inRow;
    currentWeatherState = new WeatherClear();
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
    currentWeatherState.paint(g, mousePos);
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

  public void weatherUpdate(String weatherType){
    switch (weatherType) {
    case rain: 
        currentWeatherState = new WeatherRain(this);
      break; // Exits the switch statement
    case temp:
        currentWeatherState = new WeatherTemp(this);
      break;
    case windx:
    currentWeatherState = new WeatherWindX(this);
      break;
    case windy:
    currentWeatherState = new WeatherWindY(this);
      break;
    default:
        currentWeatherState = new WeatherClear();
        break;



  }

  //state machine to be done

  
}
}
  