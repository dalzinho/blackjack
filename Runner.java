public class Runner{

  public static void main(String[] args) {
    Deck deck = new Deck();
    Dealer dealer = new Dealer();

    for (Card card : deck.cards){
      System.out.println(card.prettyName() + ", " +card.gameValue());
      } 

      dealer.takeCard(deck);
      Card card = dealer.getCard();
      System.out.println(card.prettyName());
     
  }

}