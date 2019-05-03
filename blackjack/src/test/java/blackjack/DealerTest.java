package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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