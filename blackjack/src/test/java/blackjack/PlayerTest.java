package blackjack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {


  // todo quite a bit of refactoring needed here
  @Mock
  private Deck deck;

  private List<Card> hand;

  private Player player;

  @Before
  public void before(){
    player = new Player();
    initMocks(this);
  }

  @Test
  public void takesCardFromDeck(){
    player.takeCard(deck.removeCard());
    hand = player.getHand();
    assertEquals(1, hand.size());
  }

  // todo enums for suits and face values
  @Test
  public void canGetCardsTotal(){
    Card aceOfSpades = new Card("Spades", "Ace", 14);
    Card fiveOfHearts = new Card("Hearts", "Five", 5);

    when(deck.removeCard()).thenReturn(aceOfSpades);
    player.takeCard(deck.removeCard());

    when(deck.removeCard()).thenReturn(fiveOfHearts);
    player.takeCard(deck.removeCard());
    assertEquals(19, player.getCardsTotalValue());
  }

  @Test
  public void returnsPrettyNameForOneCard(){
    player.takeCard(deck.removeCard());
    String test = player.showCardsHeld();
    assertNotNull(test);
  }

  @Test
  public void returnsPrettyNameForTwoCards(){
    player.takeCard(deck.removeCard());
    player.takeCard(deck.removeCard());
    String test = player.showCardsHeld();
    assertNotNull(test);
  }

  @Test
  public void handOver21ReportsLoss(){
    player.setCardsTotalValue(22);
    assertEquals(true, player.evaluateHandForLoss());
  }

  @Test
  public void handOf21ReportsWin(){
    player.setCardsTotalValue(21);
    assertEquals(true, player.evaluateHandForWin());
  }

  @Test
  public void canEvaluateHandLessThan21(){
    player.setCardsTotalValue(1);
    assertEquals(true, player.evaluateHandForNotBust());
  }
}