import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;



public class WeatherTemp implements WeatherState {

int ovalX;
int ovalY;
int offset  = 2;
int ovalWidth;
int ovalHeight;



 public WeatherTemp(Cell thisCell){
        ovalX = thisCell.x + offset;
        ovalY = thisCell.y +offset;

        ovalWidth = 5;
        ovalHeight = 5;
    }

@Override
    public void paint (Graphics g, Point mousePos)
    {
        g.setColor(Color.RED);
        g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
    }}
