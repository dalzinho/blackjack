package blackjack.game;

import blackjack.deck.Card;
import blackjack.deck.Deck;
import blackjack.deck.FaceValue;
import blackjack.deck.Suit;
import blackjack.output.BlackjackGui;
import blackjack.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
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
  public void testDealCausesEachPlayerToGetTwoCards() {
    when(gui.twistOrStick()).thenReturn('s');
    game.start();
    verify(player1, times(2)).addCardToHand(any());
    verify(player2, times(2)).addCardToHand(any());
  }

  @Test
  public void testTwistLogic() {
    when(gui.twistOrStick()).thenReturn('t', 's');
    when(deck.removeCard()).thenReturn(Deck.buildDeck().removeCard());
    game.start();
    verify(deck, atLeastOnce()).removeCard();
    verify(player1, atLeastOnce()).addCardToHand(any());
    verify(gui, atLeastOnce()).display(startsWith("You get the "));
  }


}
