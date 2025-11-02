import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;



public class WeatherWind implements WeatherState {

int lineX;
int lineY;
int offset  = 2;
int lineWidth;
int lineHeight;



 public WeatherWind(Cell thisCell){
        lineX = thisCell.x + offset;
        lineY = thisCell.y +offset;


        lineWidth = 10;
        lineHeight = 2;
    }

@Override
    public void paint (Graphics g, Point mousePos)
    {
        g.setColor(Color.WHITE);
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }}
