public class Runner{

  public static void main(String[] args) {
    Deck deck = new Deck();

    for (Card card : deck.cards){
      System.out.println(card.prettyName() + ", " +card.gameValue());
    }  
  }

}