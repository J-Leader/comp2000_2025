import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WeatherReporter {
    ArrayList<ArrayList<Cell>> cellsInGrid;

public WeatherReporter(Cell[][] cells){
       cellsInGrid = Arrays.stream(cells)
                .map(innerArray -> Arrays.stream(innerArray)
                        .collect(Collectors.toCollection(ArrayList::new))) // Collect inner array to ArrayList<Integer>
                .collect(Collectors.toCollection(ArrayList::new)); // Collect outer stream to ArrayList<ArrayList<Integer>>


                //System.out.println(cellsInGrid.get(0).get(0).col);

}


public void subscribe(Cell newCell){

}

public void unsubscribe(Cell newCell){

}

public void update(ArrayList<String[]> weatherReport){
    for (String[] Pieces : weatherReport) {
        System.out.println(Pieces[2]);
        System.out.println(Pieces[3]);
    }
}

}
