package blackjack.deck;

import blackjack.deck.Card;
import org.junit.Before;
import org.junit.Test;

import static blackjack.deck.FaceValue.TWO;
import static blackjack.deck.Suit.HEARTS;
import static org.junit.Assert.assertEquals;


public class CardTest {
  private Card card;

  @Before
  public void before(){
    card = new Card(HEARTS, TWO);
  }

  // todo fix pretty names for enums
  @Test
  public void canWritePrettyName(){
    assertEquals("Two of Hearts", card.prettyName());
  }

  @Test
  public void canShareGameValue(){
    assertEquals(2, card.getGameValue());
  }

}