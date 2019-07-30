package highcard;

import cards.deck.Deck;
import cards.game.highcard.HighCard;
import cards.output.CardsGui;
import cards.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class GameTest{

  @Mock
  Player player1;

  @Mock
  Player player2;

  @Mock
  CardsGui gui;

  @Mock
  Deck deck;

  @InjectMocks
  HighCard highCard = new HighCard(player1, player2, deck, gui);

  @Before
  public void before(){
    initMocks(this);
  }

  @Test
  public void p1CanWin(){
    testCase(2, 1, "Player One wins!");
  }

  @Test
  public void p2CanWin(){
    testCase(1, 2, "Player Two wins!");
  }

  @Test
  public void playersCanDraw(){
    testCase(2, 2, "It's a Draw!");
  }

  private void testCase(int p1Score, int p2Score, String expectedText) {
    when(player1.getHandValue()).thenReturn(p1Score);
    when(player2.getHandValue()).thenReturn(p2Score);
    highCard.start();
    verify(gui, times(1)).display(expectedText);
  }
}
