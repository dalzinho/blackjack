package blackjack.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private final List<Card> cards;

  public Deck() {
    this.cards = new ArrayList<>();

    for(Suit suit : Suit.values()){
      for(FaceValue fv : FaceValue.values()){
        Card card = new Card(suit, fv);
        this.cards.add(card);
        
      }
    }

    Collections.shuffle(cards);
  }

  public Card removeCard(){
    Card card = cards.get(0);
    cards.remove(0);
    return card;
  }

  public int cardsRemaining() {
    return cards.size();
  }


}