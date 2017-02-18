import java.util.ArrayList;

public class Player {

  private ArrayList<Card> hand;
  private int cardsTotalValue;
  private StringBuilder cardsHeld;

  public Player(){
    hand = new ArrayList<Card>();
    cardsHeld = new StringBuilder();
  }

  public ArrayList<Card> getHand(){
    return this.hand;
  }

  public int getCardsTotalValue(){
    return this.cardsTotalValue;
  }

  public void takeCard(Deck deck){
    Card card = deck.removeCard();
    this.hand.add(card);
    cardsTotalValue += card.getGameValue();
  }

  public String showCardsHeld(){
    for(Card card : hand){
    cardsHeld.append(card.prettyName());
    cardsHeld.append(", ");
    }
    cardsHeld.append("Total Score: " + cardsTotalValue);
    return cardsHeld.toString();
}
}