package blackjack;

import java.util.ArrayList;

public class Player {

  private ArrayList<Card> hand;
  private int cardsTotalValue;
  private StringBuilder cardsHeld;

  public Player(){
    hand = new ArrayList<Card>();
    cardsHeld = new StringBuilder();
  }

  // for testing purposes
  public void setCardsTotalValue(int x){
    this.cardsTotalValue = x;
  }

  public void recalculateCardsTotalValue(){
    int total = 0;
    for(Card card : hand){
      total += card.getGameValue();
    }
    this.cardsTotalValue = total;
  }

  public ArrayList<Card> getHand(){
    return this.hand;
  }

  public Card getLastCardInHand(){
    return this.hand.get(hand.size()-1);
  }

  public int getCardsTotalValue(){
    if(this.cardsTotalValue > 21){
      for (Card card : hand){
        if (card.getFaceValue() == "Ace"){
          card.setGameValue(1);
        }
      }
      this.recalculateCardsTotalValue();
    }
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

  public boolean evaluateHandForLoss() {
    return cardsTotalValue > 21;
  }

  public boolean evaluateHandForWin() {
    return cardsTotalValue == 21;
  }

  public boolean evaluateHandForNotBust() {
    return cardsTotalValue < 21;
  }



}