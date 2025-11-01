import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class WeatherStation {
ArrayList<String[]> weatherReport;

public void /*ArrayList<String[]>*/  checkWeather(){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://13.238.167.130/weather"))
                .header("Accept", "text/event-stream")
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
                .thenApply(HttpResponse::body)
                .thenAccept(inputStream -> {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                        weatherReport = reader.lines()
                                .map(line -> line.split(" "))
                                .limit(10)
                                .collect(Collectors.toCollection(ArrayList::new));
                                /* .forEach(parts ->{
                                System.out.println(parts[0]);
                                


                                })*/
                                ;
                               
                    } catch (IOException e) {
                        System.err.println("Error reading Server Side Event (SSE) stream: " + e.getMessage());
                    }
                     
                })
                .join(); // Wait for the async operation to complete
            
                //return weatherReport;

    }
}

