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
        // Collections.shuffle(cards);
      }
    }
    for(Card card : cards){
      String fv = card.getFaceValue();

      switch (fv) {
        case "Two": card.setGameValue(2);
        case "Three" : card.setGameValue(3);
        case "Four": card.setGameValue(4);
        case "Five" : card.setGameValue(5);
        case "Six": card.setGameValue(6);
        case "Seven" : card.setGameValue(7);
        case "Eight": card.setGameValue(8);
        case "Nine" : card.setGameValue(9);
        case "Ten": card.setGameValue(10);
        case "Jack" : card.setGameValue(11);
        case "Queen": card.setGameValue(12);
        case "King" : card.setGameValue(13);
        case "Ace": card.setGameValue(14);
      }
    }
  }
  


}