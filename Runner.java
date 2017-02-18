public class Runner{

  public static void main(String[] args) {
    Deck deck = new Deck();
    Dealer dealer = new Dealer();
    Player player = new Player();

    for (Card card : deck.cards){
      System.out.println(card.prettyName() + ", " +card.getGameValue());
      } 

      player.takeCard(deck);

      System.out.println(player.showCardsHeld());
      System.out.println(player.getCardsTotalValue());

     
  }

}