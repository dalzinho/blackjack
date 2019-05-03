package blackjack;

import blackjack.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private String name;
  private List<Card> hand;
  private int cardsTotalValue;

  public Player(String name) {
    this();
    this.name = name;
  }

  public Player(){
    hand = new ArrayList<>();
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

  public List<Card> getHand(){
    return this.hand;
  }

  public Card getLastCardInHand(){
    return this.hand.get(hand.size()-1);
  }

  private int acesLowScore(List<Card> hand) {
    return hand
            .stream()
            .mapToInt(card -> card.isAce() ? 1 : card.getGameValue())
            .sum();
  }

  public int getCardsTotalValue(){
    int totalValue = hand.stream()
            .mapToInt(Card::getGameValue)
            .sum();

    if(totalValue > 21){
      // todo aces low scenario
      totalValue = acesLowScore(hand);
    }
    return totalValue;
  }

  public void takeCard(Card card){
    this.hand.add(card);
  }

  public String showCardsHeld(){
    StringBuilder cardsHeld = new StringBuilder();
    for(Card card : hand){
      cardsHeld.append(card.prettyName());
      cardsHeld.append(", ");
    }
    cardsHeld.append("Total Score: ").append(getCardsTotalValue());
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

  public String getName() {
    return name;
  }
}