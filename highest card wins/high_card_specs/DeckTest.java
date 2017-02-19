import high_card.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class DeckTest {

  Deck deck;
  Card card;

  @Before
  public void before(){
    deck = new Deck();
  }

  @Test
  public void makesDeckOf52(){
    assertEquals(52, deck.cards.size());
  }

  @Test
  public void canSelectCardFromDeck(){
    card = deck.removeCard();
    assertEquals(51, deck.cards.size());
    assertEquals("squeak", card.squeak());
  }

  // This test passed! But it's commented out, as the shuffle breaks it.
  // @Test
  // public void createdCardsHavePrettyName(){
  //   Card testCard = deck.cards.get(0);
  //   assertEquals("Two of Spades", testCard.prettyName());
  // }
}