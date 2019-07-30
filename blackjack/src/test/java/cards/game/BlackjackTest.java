package cards.game;

import cards.deck.Deck;
import cards.game.blackjack.Blackjack;
import cards.output.CardsGui;
import cards.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class BlackjackTest {

  @Mock
  Player player1;

  @Mock
  Player player2;

  @Mock
  Deck deck;

  @Mock
  CardsGui gui;

  @InjectMocks
  Blackjack blackjack = new Blackjack(player1, player2, deck, gui);

  @Before
  public void before(){
    initMocks(this);
  }

  @Test
  public void testDealCausesEachPlayerToGetTwoCards() {
    when(gui.twistOrStick()).thenReturn('s');
    blackjack.start();
    verify(player1, times(2)).addCardToHand(any());
    verify(player2, times(2)).addCardToHand(any());
  }

  @Test
  public void testTwistLogic() {
    when(gui.twistOrStick()).thenReturn('t', 's');
    when(deck.removeCard()).thenReturn(Deck.buildDeck().removeCard());
    blackjack.start();
    verify(deck, atLeastOnce()).removeCard();
    verify(player1, atLeastOnce()).addCardToHand(any());
    verify(gui, atLeastOnce()).display(startsWith("You get the "));
  }


}
