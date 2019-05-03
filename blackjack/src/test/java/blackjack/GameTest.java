package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GameTest{

  Game game;

  @Before
  public void before(){
    game = new Game();
  }

  @Test
  public void p1CanWin(){
    assertEquals("Player One wins!", game.decide(2,1));
  }

  @Test
  public void p2CanWin(){
    assertEquals("Player Two wins!", game.decide(1,2));
  }

  @Test
  public void playersCanDraw(){
    assertEquals("It's a Draw!", game.decide(1,1));
  }

}
