package cards.deck;

import org.junit.Before;
import org.junit.Test;

import static cards.deck.FaceValue.TWO;
import static cards.deck.Suit.HEARTS;
import static org.junit.Assert.assertEquals;


public class CardTest {
  private Card card;

  @Before
  public void before(){
    card = new Card(HEARTS, TWO);
  }

  @Test
  public void canWritePrettyName(){
    assertEquals("Two of Hearts", card.prettyName());
  }

  @Test
  public void canShareGameValue(){
    assertEquals(2, card.getGameValue());
  }

}