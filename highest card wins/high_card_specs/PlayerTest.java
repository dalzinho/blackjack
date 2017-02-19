import high_card.*;

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
}