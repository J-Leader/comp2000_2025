import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
     

    public static void main(String[] args) throws IOException, InterruptedException {
        Random rand = new Random();
        int randomSpawnValue = rand.nextInt(4);
        long myLong = randomSpawnValue;
        List<String[]> weatherList;

        weatherList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://13.238.167.130/weather"))
                .header("Accept", "text/event-stream")
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
                .thenApply(HttpResponse::body)
                .thenAccept(inputStream -> {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                            reader.lines()
                                .map(line -> line.split(" "))
                                //.skip(myLong)
                                //.filter(pieces -> Float.parseFloat(pieces[4]) < 0.4)
                                //.limit(1)   
                                 //.collect(Collectors.toList());
                                   .forEach(pieces ->{
                                    testLoader(pieces);
                                    System.out.println("Receieved new weather event at x:" + pieces[1]);
                                    System.out.println("Receieved new weather event at x:" + pieces[2]);
                                    System.out.println("Receieved new weather event at y:" + pieces[3]);
                                    

                                    //run once, collect, take and apply the transformation in a weather tracker class? Loop it there?
                                    //simplest implementation, have that class lean into design patterns and have lambda's define conditions
                                    //pieces 1 is weather condition
                                    //pieces 2 is x coord
                                    //pieces 3 is y coord
                                    //pieces 4 is float value
                                    
                                    //maybe forEach and then a lambda for each condition.
                                    //cells need a currentWeatherCondition variable
                                    // Weather class?
                                    // specific weather subclasses?
                                    //Observer pattern that monitors the weather and informs that cells need to change weather.
                                });


                                
                  

                    } catch (IOException e) {
                        System.err.println("Error reading Server Side Event (SSE) stream: " + e.getMessage());
                    }
                })
                .join(); // Wait for the async operation to complete
    }


    public static void testLoader(String[] test){
        weatherList.add(test);
    }



}