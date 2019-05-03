package blackjack;

import blackjack.output.BlackjackGui;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class GameTest{

  @Mock
  Player player1;

  @Mock
  Player player2;

  @Mock
  Deck deck;

  @Mock
  BlackjackGui gui;

  @InjectMocks
  Game game = new Game(player1, player2, deck, gui);

  @Before
  public void before(){
    initMocks(this);
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
