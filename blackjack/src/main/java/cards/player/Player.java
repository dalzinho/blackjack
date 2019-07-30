package cards.player;

import cards.deck.Card;
import cards.hand.Hand;

public class Player {

  private static final String CARDS_HELD = "Cards Held: ";
  private static final String TOTAL_SCORE = "Total Score: ";

  private String name;
  private Hand hand;

  public Player(String name, Hand hand) {
    this.name = name;
    this.hand = hand;
  }

  public int getHandValue() {
    return hand.getHandValue();
  }

  public void addCardToHand(Card card){
    hand.add(card);
  }

  public boolean isBust() {
    return hand.getHandValue() > 21;
  }

  public boolean hasTwentyOne() {
    return hand.getHandValue() == 21;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {
    return CARDS_HELD + hand.getCardPrettyNames() + "; " + TOTAL_SCORE + hand.getHandValue();
  }

  public void clearHand() {
    hand = new Hand();
  }

}