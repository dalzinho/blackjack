package blackjack;

import blackjack.deck.Card;
import blackjack.deck.Deck;
import blackjack.deck.FaceValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static blackjack.deck.FaceValue.*;
import static blackjack.deck.Suit.HEARTS;
import static blackjack.deck.Suit.SPADES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {


  // todo quite a bit of refactoring needed here
  @Mock
  private Deck deck;

  private Player player;

  @Before
  public void before(){
    player = new Player();
    initMocks(this);
  }

  @Test
  public void takesCardFromDeck(){
    player.takeCard(deck.removeCard());
    List<Card> hand = player.getHand();
    assertEquals(1, hand.size());
  }

  // todo enums for suits and face values
  @Test
  public void canGetCardsTotal(){
    Card aceOfSpades = new Card(SPADES, FaceValue.ACE);
    Card fiveOfHearts = new Card(HEARTS, FaceValue.FIVE);

    when(deck.removeCard()).thenReturn(aceOfSpades);
    player.takeCard(deck.removeCard());

    when(deck.removeCard()).thenReturn(fiveOfHearts);
    player.takeCard(deck.removeCard());
    assertEquals(16, player.getCardsTotalValue());
  }

  @Test
  public void returnsPrettyNameForOneCard(){
    player.takeCard(new Card(HEARTS, KING));
    String test = player.showCardsHeld();
    assertNotNull(test);
  }

  @Test
  public void returnsPrettyNameForTwoCards(){
    player.takeCard(new Card(HEARTS, KING));
    player.takeCard(new Card(HEARTS, QUEEN));
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

  @Test
  public void handlesAcesLowScenario()  {
    player.takeCard(new Card(HEARTS, KING));
    player.takeCard(new Card(HEARTS, QUEEN));
    player.takeCard(new Card(HEARTS, ACE));
    assertEquals(21, player.getCardsTotalValue());
  }
}