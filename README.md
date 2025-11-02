
Design Patterns

- Observer Pattern has been used in the handling of weather updating cells. With WeatherReporter acting as an observer of the WeatherStation. WeatherStation is called in the SelectingNewLocation game state at the end of a turn (When the player has used up all the enabled actors turns). The new weatherReport is passed to the WeatherReporter who calls the update method in it's subscribers (The list of cells made when the grid is initialised). Using this pattern allows for theoretical expansion during runtime, with a subscribe and unsubscribe method in the obserer to add or remove cells from the list of subscribers. While also making the code easier to both understand and maintain, as the components can easily be broken down and changed.

- State pattern has been used in handling the weather. Cells have been assigned a WeatherState, an interface implemented by WeatherTemp, WeatherRain and WeatherWind. Using this pattern, allows me to override the WeatherState paint method, letting me show what weatherState is affecting the relevant cell. The pattern allows for greater flexibility in terms of both maintainence and future expansion as more WeatherState's can be implemented rather easily. Maintainence has been improved by seperating the classes, so that any issues can be easily isolated and debugged. Cells have a switch case which handles the switching of their own state so that the Observer pattern can function as it should. 



Stream Operations

- The WeatherStation program, requests an input stream from the weather URI link and streams it through a BufferedReader. 

- reader.lines() begins the stream of string elements

- I immediately use .limit(10) to truncate the stream after the first 10 elements. I do this immediately to improve performance as it means that further operations do not need to be applied to the entire stream, only the 10 remaining elements. 10 IS an arbitrary value but it nearly guarentees multiple cells worth of intaken weather data.

- .map() is used in conjunction with a lambda statement to split the stream of strings, into a stream of string[]'s which allows me to manipulate the individual parts of the data. e.g. pieces[1] is the weather effect identifier such as temp or rain. 

.forEach() is a terminal operation that closes the stream, but I also use a lambda there to both ensure that

- none of my cell co-ordinates have negative values (This would negatively affect my ability to use existing methods to find the cell the data is referencing)

- to then add each element to an ArrayList of String[]. This could have been acheived by using .collect() and collecting to fill the list, however I wanted to use the forEach in order to increment through the elements and manipulate the co-ordinates as described above.

The WeatherStation's checkWeather() method handles all of the above and is called in the SelectingNewLocation game state at the end of a turn, the method is void and doesn't return the weatherReport list. But rather updates the weatherReport list of the WeatherStation object in the Grid object. This lets the WeatherReporter Observer Object in the grid access the weatherReport list directly and use it in its weatherUpdate() method. 

the weatherUpdate() method uses .forEach() in conjunction with lambdas to determine which data elements in weatherReports should be applied. The random value is used to ensure that sometimes the weather data chosen is not simply the first instance of data affecting that cell. Making use of the pattern of differing strength depending on weather type in the initial data set. The update method also passes updated weather data to the relevant cells. Acting as part of the observer pattern.

Timestamp has not been used

the weather conditions have been isolated into 3 weather States, rain, temp and wind. These states each correspoind to one of the actors i,e cat, dog and bird respectively and represent states that make their respective actors unable to enter those cells. e.g the cat doesnt want to walk in the rain. This in combination with the already limited movement and unique cell types that I had planned for in assignment 1, but have expanded on and finalised here in assignment 2. (The bird can fly anywhere, the cat cannot swim and the dog cannot climb the mountains). Can result in the player being unable to move and the actor becoming disabled and unable to be picked (The game has a loss state where none of the actors can move, meaning a GAME OVER). The weather updates at the end of every turn

The co-ordinates have been used as X and Y values for determining which cells are affected by weather, I've manipulated the co-ords in the forEach() operation to ensure that there are no negative co-ordinates as described above.

the power value has been used as described above, in conjunction with a random value to ensure that the applied weather effect is random. Rather than rain (The first weather effect for each cell in the stream).



