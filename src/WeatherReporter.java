import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
  import java.util.stream.Collectors;

public class WeatherReporter {
    String lastX;
    String lastY;
    ArrayList<String[]> weatherUpdate;
    Grid gridReference;
    Random rand;
    double min;
    double max;
    Cell[][] subscribedCells;



public WeatherReporter(Cell[][] cells, Grid grid){
     rand = new Random();
     min = 0.38;
     max = 0.55;
     subscribedCells = cells;
     

        weatherUpdate = new ArrayList<String[]>();

        gridReference = grid;
}


public void subscribe(Cell newCell)
{
    subscribedCells[gridReference.labelToCol(newCell.col)][newCell.row] = newCell;
}

public void unsubscribe(Cell newCell)
{
    subscribedCells[gridReference.labelToCol(newCell.col)][newCell.row] = null;
}

public void update(ArrayList<String[]> weatherReport){
   
    weatherUpdate.clear();

    //determines whether or not the cell being processed has already been affected this turn, AND uses a random value to determine what weather effect should be applied.
    weatherReport.forEach(Pieces ->{
         double randomSpawnValue = min + (max - min) * rand.nextDouble();
        if((!Pieces[2].equals(lastX) || !Pieces[3].equals(lastY)) && Double.parseDouble(Pieces[4]) > randomSpawnValue)
        {
            lastX = Pieces[2];
            lastY = Pieces[3];
            weatherUpdate.add(Pieces);
        }

    });

    weatherUpdate.forEach(Updates -> {
        Cell updatedCell = subscribedCells[Integer.parseInt(Updates[2])][Integer.parseInt(Updates[3])];
        updatedCell.weatherUpdate(Updates[1]);
   });
    
}



}
