import java.util.ArrayList;
import java.util.Collections;

public class Deck {

  public ArrayList<Card> cards;
  private int gameValue;

  public Deck() {

    this.cards = new ArrayList<Card>();
    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] faceValue = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};


    for(String suit : suits){
      for(String fv : faceValue){
        Card card = new Card(suit, fv, 1);
        this.cards.add(card);
        
      }
    }
    for(Card card : cards){
      String fv = card.getFaceValue();

      switch (fv) {
        case "Two": card.setGameValue(2);
        break;
        case "Three" : card.setGameValue(3);
        break;
        case "Four": card.setGameValue(4);
        break;        
        case "Five" : card.setGameValue(5);
        break;        
        case "Six": card.setGameValue(6);
        break;        
        case "Seven" : card.setGameValue(7);
        break;        
        case "Eight": card.setGameValue(8);
        break;        
        case "Nine" : card.setGameValue(9);
        break;        
        case "Ten": card.setGameValue(10);
        break;        
        case "Jack" : card.setGameValue(10);
        break;        
        case "Queen": card.setGameValue(10);
        break;
        case "King" : card.setGameValue(10);
        break;
        case "Ace": card.setGameValue(11);
        break;
        
      }
    }
    Collections.shuffle(cards);
  }

  public Card removeCard(){
    Card card = cards.get(0);
    cards.remove(0);
    return card;
  }


}