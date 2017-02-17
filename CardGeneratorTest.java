import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class CardGeneratorTest {
  ArrayList<Card> deck;

  @Before
  public void before(){
    deck = CardGenerator.getDeck();
  }

  @Test
  public void makesDeckOf52(){
    assertEquals(52, deck.size());
  }

  // @Test
  // public void createdCardsHavePrettyName(){
  //   assertEquals("Two of Spades", deck.get(0).prettyName());
  // }
}