package blackjack.player;

import blackjack.deck.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

  private static final String CARDS_HELD = "Cards Held: ";
  private static final String TOTAL_SCORE = "Total Score: ";
  private static final String COMMA_SEPARATOR = ", ";

  private String name;
  private List<Card> cards;

  public Player(String name) {
    this.cards = new ArrayList<>();
    this.name = name;
  }

  private int acesLowScore(List<Card> hand) {
    return hand
            .stream()
            .mapToInt(card -> card.isAce() ? 1 : card.getGameValue())
            .sum();
  }

  public int getCardsTotalValue(){
    int totalValue = cards.stream()
            .mapToInt(Card::getGameValue)
            .sum();

    if(totalValue > 21){
      totalValue = acesLowScore(cards);
    }

    return totalValue;
  }

  public void addCardToHand(Card card){
    this.cards.add(card);
  }

  private String getCardPrettyNames(){
    List<String> prettyNames = cards.stream().map(Card::prettyName).collect(Collectors.toList());
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
    return CARDS_HELD + getCardPrettyNames() + "; " + TOTAL_SCORE + getCardsTotalValue();
  }

}