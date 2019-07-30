package cards.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    private Deck(List<Card> cards) {
        this.cards = cards;
    }

    public static Deck buildDeck() {
        List<Card> cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (FaceValue fv : FaceValue.values()) {
                Card card = new Card(suit, fv);
                cards.add(card);
            }
        }

        Collections.shuffle(cards);

        return new Deck(cards);
    }

    public Card removeCard() {
        if (cards.isEmpty()) {
            throw new DeckException("Cannot remove card from empty deck!");
        }

        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }
}
