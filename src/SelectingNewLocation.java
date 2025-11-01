import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Optional;

public class SelectingNewLocation implements GameState {
  @Override
  public void mouseClick(int x, int y, Stage s) {
    Optional<Cell> clicked = Optional.empty();
    for(Cell c: s.cellOverlay) {
      if(c.contains(x, y)) {
        clicked = Optional.of(c);
      }
    }
    s.cellOverlay = new ArrayList<Cell>();
    if(clicked.isPresent() && s.playerInAction.isPresent()) {
      s.playerInAction.get().setLocation(clicked.get());
      s.playerInAction.get().turns--;
      int humansWithMovesLeft = 0;
      for(Actor player: s.listOfPlayers) {
        if(!player.isBot() && player.turns > 0) {
          humansWithMovesLeft++;
        }
      }
      if(humansWithMovesLeft > 0) {
        s.currentState = new ChoosingActor();
      } else { //TURN END CODE
        s.currentState = new BotMoving();
        s.grid.weatherStation.checkWeather();
        s.grid.weatherReporter.update(s.grid.weatherStation.weatherReport);
        //System.out.println(s.grid.weatherStation.weatherReport);
      }
    }
    else// what to do if cliced was not present
    {
      System.out.println("Not a valid move, please try again");
      s.currentState = new ChoosingActor();
    }
  }

  @Override
  public void paint(Graphics g, Stage s) {
    // no paint activity for this GameState
  }

  public String toString() {
    return getClass().getSimpleName();
  }
}
