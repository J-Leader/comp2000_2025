import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WeatherReporter {
    ArrayList<ArrayList<Cell>> cellsInGrid;

    String lastX;
    String lastY;
    ArrayList<String[]> weatherUpdate;
    Grid gridReference;



public WeatherReporter(Cell[][] cells, Grid grid){
       cellsInGrid = Arrays.stream(cells)
                .map(innerArray -> Arrays.stream(innerArray)
                        .collect(Collectors.toCollection(ArrayList::new))) // Collect inner array to ArrayList<Integer>
                .collect(Collectors.toCollection(ArrayList::new)); // Collect outer stream to ArrayList<ArrayList<Integer>>
        weatherUpdate = new ArrayList<String[]>();

        gridReference = grid;
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

    });

    weatherUpdate.forEach(Updates -> {
        //Updates[3] = Character.toString(gridReference.colToLabel(Integer.parseInt(Updates[3])));  //turn column into letters
        
        Cell updatedCell = gridReference.cellAtColRow(Integer.parseInt(Updates[2]), Integer.parseInt(Updates[3])).get();
        updatedCell.weatherUpdate(Updates[1]);
        System.out.println(updatedCell);

   });
    
}



}
