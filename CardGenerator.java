import java.util.ArrayList;

public class CardGenerator{

  private static ArrayList<Card> deck;
 

  public CardGenerator() {
    
    this.deck = new ArrayList<Card>();
    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] faceValue = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    int[] gameValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    for(String suit : suits){
      for(String fv : faceValue){
        Card card = new Card(suit, fv, 1);
          this.deck.add(card);
        }
      }
    }
  

  public static ArrayList<Card> getDeck(){
    return deck;
  }
}