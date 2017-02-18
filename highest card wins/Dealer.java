public class Dealer {
  
  private Card card;

  public void takeCard(Deck deck){
    this.card = deck.removeCard();
  }
  
  public Card getCard(){
    return this.card;
  }



}