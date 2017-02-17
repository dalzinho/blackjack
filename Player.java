import java.util.ArrayList;

public class Player {

  ArrayList<Card> hand;

  public void takeCard(Dealer dealer){
    hand.add(dealer.getCard());
// this.hand.add(card);
  }

  
}