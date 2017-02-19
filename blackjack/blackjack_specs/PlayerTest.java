import blackjack.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class PlayerTest {
  
  Player player;
  Deck deck;
  ArrayList<Card> hand;

  @Before
  public void before(){
    player = new Player();
    deck = new Deck();
  }

  @Test
  public void takesCardFromDeck(){
    player.takeCard(deck);
    hand = player.getHand();
    assertEquals(1, hand.size());
  }

  @Test
  public void canGetCardsTotal(){
    player.takeCard(deck);
    hand = player.getHand();
    int ctv = player.getCardsTotalValue();
    boolean x = ctv > 0 && ctv < 15;
    assertEquals(true, x);
  }

  @Test
  public void returnsPrettyNameForOneCard(){
    player.takeCard(deck);
    String test = player.showCardsHeld();
    assertNotNull(test);
  }

  @Test
  public void returnsPrettyNameForTwoCards(){
    player.takeCard(deck);
    player.takeCard(deck);
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