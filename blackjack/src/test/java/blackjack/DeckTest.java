package blackjack;

import blackjack.deck.Card;
import blackjack.deck.Deck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

  Deck deck;
  Card card;

  @Before
  public void before(){
    deck = new Deck();
  }

  @Test
  public void makesDeckOf52(){
    assertEquals(52, deck.cardsRemaining());
  }

  @Test
  public void canSelectCardFromDeck(){
    card = deck.removeCard();
    assertEquals(51, deck.cardsRemaining());
    assertEquals("squeak", card.squeak());
  }

  // @Test
  // public void hasGameValue(){
  //   Card testCard1 = deck.cards.get(0);
  //   Card testCard2 = deck.cards.get(12);
  //   Card testCard3 = deck.cards.get(32);
  //   Card testCard4 = deck.cards.get(43);

  //   assertEquals(14, testCard1.gameValue());
  //   assertEquals(14, testCard2.gameValue());
  //   assertEquals(14, testCard3.gameValue());
  //   assertEquals(14, testCard4.gameValue());
  // }

  // This test passed! But it's commented out, as the shuffle breaks it.
  // @Test
  // public void createdCardsHavePrettyName(){
  //   Card testCard = deck.cards.get(0);
  //   assertEquals("Two of Spades", testCard.prettyName());
  // }
}