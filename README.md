# Welcome to COMP2000 - Object Oriented Programming Practices
## Session 2, 2025

This README has been altered from the original README file supplied by the COMP2000_2025 repository for this assignment branch specifically.  

Inheritance has been used extensively in the alterations made to the base week 5 work for the purposes of this assignment, this is particularly evident in the changes made to the Actor and Cell classes and my implementation of several subclasses of Cell in the form of Mountain, Grass and Lake as well as the interface animalBehaviour.

An initial change to actor is the super constructor that its subclasses now use. The subclasses all contained 
loc = inLoc;
    display = new ArrayList<>();

Which left some room for code redundancy and assuming the implementation of Actors remained the same as more Actor subclasses were added would result in needless overhead, hence all Actor subclass constructors now simply Super() the Actor constructor. 

The Actor class now implements the interface animalBehaviour, supplying it and its subclasses with access to the template methods for void onHovered() and void offHovered(). 

This interface were created both to add functionality to the existing Actor subclasses, but also to open the door for future implementation of Objects which are not Actors that the user may hover over on the grid, such as hostile or friendly NPCs. The functionality of these methods can be extended in the future, while allowing for a consistent template. Furthermore in the case of future implentation it leaves room for any future classes to implement other interfaces, in case they serve other purposes while still needing a method for when the user hovers over them.

These methods have been called in the Actor function isHovered() which is called in the Actor paint method and checks whether the user's mouse is currently hovering over that Actors cell. If it is and the Actor has not performed the hover function, the script calls specifically this.onHovered. The use of an interface and the Actor subclasses, Cat, Dog and Bird inheriting the implementation of the interface rather than a method from Actor means that each subclass may define its own unique onHovered() function. Opening design room for different Actors to also act differently, in my implementation the bird chirps, the dog barks and the cat tries to blend in with the grass (changes colour). This reasoning also applies to the offHovered function(). 

The Actor class now also contains the findPassableCells() method and several new ArrayList variables, though they'll be discussed in the generics section. This method is called in a for loop in the Stage constructor after the grid is constructed and the actors are added to the actors list. The function rellies on both the created Grid class which contains the cells array, and an arraylist called possibleMovementTemplate. This method and its associated variables such as possibleMovementTemplate have been created in the Actor class so they are inherited by each Actor subclass, this reduces code redundancy significantly, while ensuring that each subclass is responsible for and contains what it needs to add to its possibleMovementTemplate. This function has been created in anticipation of a movement function being added in the future and in theory restricts each Actor to only being able to move onto cells that exist in the ArrayList MoveableCells, which the stage constructor sets after the findPassableCells() method returns its arraylist of cells. 





