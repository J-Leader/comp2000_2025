import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class WeatherRain implements WeatherState{
int ovalX;
int ovalY;
int offset  = 2;
int ovalWidth;
int ovalHeight;

int triangleBaseX1;
int triangleBaseY;
int triangleBaseX2;
int trianglePointX;
int trianglePointY;

int[] xPoints = new int[3];
int[] yPoints = new int[3];

    public WeatherRain(Cell thisCell){
        ovalX = thisCell.x + offset;
        ovalY = thisCell.y +offset;

        ovalWidth = 5;
        ovalHeight = 5;


        triangleBaseX1 = ovalX;
        triangleBaseY = ovalY + ovalHeight / 2;
        triangleBaseX2 = ovalX + ovalWidth;
        trianglePointX = ovalX + ovalWidth / 2;
        trianglePointY = ovalY - offset; // Adjust for the point's height

        xPoints[0] = triangleBaseX1;
        xPoints[1] = triangleBaseX2;
        xPoints[2] = trianglePointX;

        yPoints[0] = triangleBaseY;
        yPoints[1] = triangleBaseY;
        yPoints[2] = trianglePointY;
    }


    @Override
    public void paint (Graphics g, Point mousePos)
    {
        g.setColor(Color.BLUE);
        g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
        g.fillPolygon(xPoints, yPoints, 3);
    }

}
