import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.Before;


public class DealerTest {
    
    Dealer dealer;
    Card card;
    Deck deck;

    @Before
    public void before(){
      dealer = new Dealer();
      deck = new Deck();
    }


    @Test
    public void canGetCardFromDeck(){
      dealer.takeCard(deck);
      Card card = dealer.getCard();
      assertEquals("squeak", card.squeak());
      assertEquals(51, deck.cards.size());
    }


}