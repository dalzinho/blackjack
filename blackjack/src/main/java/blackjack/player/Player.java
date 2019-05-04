package blackjack.player;

import blackjack.deck.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

  private static final String CARDS_HELD = "Cards Held: ";
  private static final String TOTAL_SCORE = "Total Score: ";
  public static final String COMMA_SEPARATOR = ", ";

  private String name;
  private List<Card> hand;

  public Player(String name) {
    this.hand = new ArrayList<>();
    this.name = name;
  }

  public String getPrettyNameOfLastCardInHand(){
    return this.hand.get(hand.size()-1).prettyName();
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
      totalValue = acesLowScore(hand);
    }

    return totalValue;
  }

  public void addCardToHand(Card card){
    this.hand.add(card);
  }

  private String showCardsHeld(){
    List<String> prettyNames = hand.stream().map(Card::prettyName).collect(Collectors.toList());
    return String.join(COMMA_SEPARATOR, prettyNames);
  }

  public boolean isBust() {
    return getCardsTotalValue() > 21;
  }

  public boolean hasTwentyOne() {
    return getCardsTotalValue() == 21;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {
    return CARDS_HELD + showCardsHeld() + "; " + TOTAL_SCORE + getCardsTotalValue();
  }

}