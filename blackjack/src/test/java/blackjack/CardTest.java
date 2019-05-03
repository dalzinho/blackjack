package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CardTest {
  Card card;

  @Before
  public void before(){
    card = new Card("Hearts", "Two", 2);
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