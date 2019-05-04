package blackjack.game;

import blackjack.deck.Deck;
import blackjack.game.Game;
import blackjack.player.Player;
import blackjack.output.BlackjackGui;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
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
  public void testBothPlayersBust() {
    when(player1.getCardsTotalValue()).thenReturn(100);
    when(player2.getCardsTotalValue()).thenReturn(100);
  }
}
