import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WeatherReporter {
    ArrayList<ArrayList<Cell>> cellsInGrid;

    String lastX;
    String lastY;
    ArrayList<String[]> weatherUpdate;



public WeatherReporter(Cell[][] cells){
       cellsInGrid = Arrays.stream(cells)
                .map(innerArray -> Arrays.stream(innerArray)
                        .collect(Collectors.toCollection(ArrayList::new))) // Collect inner array to ArrayList<Integer>
                .collect(Collectors.toCollection(ArrayList::new)); // Collect outer stream to ArrayList<ArrayList<Integer>>
        weatherUpdate = new ArrayList<String[]>();


                //System.out.println(cellsInGrid.get(0).get(0).col);

}


public void subscribe(Cell newCell){

}

public void unsubscribe(Cell newCell){

}

public void update(ArrayList<String[]> weatherReport){
    weatherUpdate.clear();
    weatherReport.forEach(Pieces ->{
        //System.out.println(Pieces[2]);
        //System.out.println(Pieces[3]);

        if(!Pieces[2].equals(lastX) && !Pieces[3].equals(lastY))
        {
            lastX = Pieces[2];
            lastY = Pieces[3];
            weatherUpdate.add(Pieces);
        }
        else
        {
            //weatherReport.remove(weatherReport.indexOf(Pieces));
        }
    });
    //System.out.println(weatherUpdate);

    
}

}
