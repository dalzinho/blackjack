package blackjack.deck;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeckTest {

  @Test
  public void testCanTake52cards() {
    List<Card> selected = removeCardsFromDeck(Deck.buildDeck(), 52);
    assertEquals(52, selected.size());
  }

  @Test(expected = DeckException.class)
  public void testThrowsExceptionOnAttemptToRemoveCardFromEmptyDeck() {
    Deck deck = Deck.buildDeck();
    List<Card> selected = removeCardsFromDeck(deck, 52);
    deck.removeCard();
  }

  private List<Card> removeCardsFromDeck(Deck deck, int cards) {
    List<Card> selected = new ArrayList<>();
    for (int i = 0; i < cards; i++) {
      selected.add(deck.removeCard());
    }
    return selected;
  }
}