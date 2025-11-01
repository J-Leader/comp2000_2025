import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;



public class WeatherWindY implements WeatherState {

int lineX;
int lineY;
int offset  = 2;
int lineWidth;
int lineHeight;

 public WeatherWindY(Cell thisCell){
        lineX = thisCell.x + offset;
        lineY = thisCell.y +offset;

        lineWidth = 2;
        lineHeight = 10;
    }

@Override
    public void paint (Graphics g, Point mousePos)
    {
        g.setColor(Color.WHITE);
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }}
