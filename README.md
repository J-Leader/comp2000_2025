# Welcome to COMP2000 - Object Oriented Programming Practices
## Session 2, 2025

This README has been altered from the original README file supplied by the COMP2000_2025 repository for this assignment branch specifically.  

Inheritance has been used extensively in the alterations made to the base week 5 work for the purposes of this assignment, this is particularly evident in the changes made to the Actor and Cell classes and my implementation of several subclasses of Cell in the form of Mountain, Grass and Lake as well as the interface animalBehaviour.

The largest initial change made to Cell is that it has been made an abstract class, furthermore 3 subclasses now extend Cell including Mountain, Grass and Lake. This was done to bring the design pattern in line with Actor. Cell is now a class that should never have objects constructed from it, instead the subclasses and any potential future subclasses of Cell should be used to populate the Grid. Making the class abstract should ensure that this is the practice used in future.

With that being said Cell still retains its constructor and in fact is used in every subclasses constructor through a super() to ensure that the subclasses still receieve and assign the relevant values that allowed Cell objects to function in the grid in the base code. 

Furthermore the Cell subclass Mountain specifically overrides the cell paint method, though it does call the cell paint method via super() to ensure proper function if the user hovers over them. This is to ensure the mountain can maintain its unique visual appearance, adding to the aesthetic of the game.

Cell now contains several new attributes that differ between subclasses, including cellColor and cellAltitude. These attributes being inherited allows for unique values in each subclass while ensuring minimal overhead in the implementation of these values. i.e ensuring that future created subclasses do not have to initialise the variable of the same name to function.

These Cell subclasses function identically to the Cell superclass they inherit from, and are inserted into the grid in the Grid constructor. Here the initial code that allowed for cells to populate the array has been replaced with a random function with a switch case that defaults to Grass, but can select to insert a Lake or Mountain into the array based off a random number. That being said inheritance allows for the cells array to still be an array of Cell objects as the subclasses are all Cells via inheritance. This use of inheritance results in a large amount of flexibility for map generation expansion in the future, as new cell subclasses can seamslessly be added to the generation switch case.

An initial change to actor is the super constructor that its subclasses now use. The subclasses all contained 
loc = inLoc;
    display = new ArrayList<>();

Which left some room for code redundancy and assuming the implementation of Actors remained the same as more Actor subclasses were added would result in needless overhead, hence all Actor subclass constructors now simply Super() the Actor constructor. 

The Actor class now implements the interface animalBehaviour, supplying it and its subclasses with access to the template methods for void onHovered() and void offHovered(). 

This interface were created both to add functionality to the existing Actor subclasses, but also to open the door for future implementation of Objects which are not Actors that the user may hover over on the grid, such as hostile or friendly NPCs. The functionality of these methods can be extended in the future, while allowing for a consistent template. Furthermore in the case of future implentation it leaves room for any future classes to implement other interfaces, in case they serve other purposes while still needing a method for when the user hovers over them.

These methods have been called in the Actor function isHovered() which is called in the Actor paint method and checks whether the user's mouse is currently hovering over that Actors cell. If it is and the Actor has not performed the hover function, the script calls specifically this.onHovered. The use of an interface and the Actor subclasses, Cat, Dog and Bird inheriting the implementation of the interface rather than a method from Actor means that each subclass may define its own unique onHovered() function. Opening design room for different Actors to also act differently, in my implementation the bird chirps, the dog barks and the cat tries to blend in with the grass (changes colour). This reasoning also applies to the offHovered function(). 

The Actor class now also contains the findPassableCells() method and several new ArrayList variables, though they'll be discussed in the generics section. This method is called in a for loop in the Stage constructor after the grid is constructed and the actors are added to the actors list. The function rellies on both the created Grid class which contains the cells array, and an arraylist called possibleMovementTemplate. This method and its associated variables such as possibleMovementTemplate have been created in the Actor class so they are inherited by each Actor subclass, this reduces code redundancy significantly, while ensuring that each subclass is responsible for and contains what it needs to add to its possibleMovementTemplate. This function has been created in anticipation of a movement function being added in the future and in theory restricts each Actor to only being able to move onto cells that exist in the ArrayList MoveableCells, which the stage constructor sets after the findPassableCells() method returns its arraylist of cells. 





Generics

Generics have been used minimally throughout the project, primarily in the form of List variables in the Actor class. I made use of String and Cell as my main type parameters, ensuring my generic List variables would take those values, but also for clarity in future code design, it ensures transparency about the intended use of the variables (in case my prefered meaningful variable names and comments were not significant enough.)





