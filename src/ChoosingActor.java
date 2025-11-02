import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChoosingActor implements GameState {
  List<Actor> enabledActors;
  @Override
  public void mouseClick(int x, int y, Stage s) {
    s.playerInAction = Optional.empty();
    enabledActors = new ArrayList<Actor>();
    for(Actor player: s.listOfPlayers) 
    {
      if(player.disabled == false)
      {
        enabledActors.add(player);
      }

      
    }

    if(enabledActors.size() == 0)
      {
        System.out.println("NO LEGAL MOVES, TRY AGAIN NEXT TIME!");
        System.out.println("GAME OVER");
        System.exit(0); 
      }


    for(Actor player: s.listOfPlayers) {
      if(player.loc.contains(x, y) && !player.isBot() && player.turns > 0) {
        s.cellOverlay = s.grid.getRadius(player.loc, player.moves, player);
        s.playerInAction = Optional.of(player);
        if(s.cellOverlay.isEmpty())
        {
          s.playerInAction.get().disabled = true;
        }


        if(s.playerInAction.get().disabled == true)
        {
          s.playerInAction.get().turns = 0;
          s.playerInAction.get().baseColor = Color.BLACK;
          System.out.println("This actor has no legal moves!");
          s.currentState = new ChoosingActor();
        }
        else
        {
          s.currentState = new SelectingNewLocation();
        }
        
      }
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
