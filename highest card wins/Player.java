import java.util.ArrayList;

public class Player {

  private ArrayList<Card> hand;
  private int cardsTotalValue;

  public Player(){
    hand = new ArrayList<Card>();
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
    return hand.get(0).prettyName();
    }
}