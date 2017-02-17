import java.util.ArrayList;

public class CardGenerator{

  static ArrayList<Card> deck = new ArrayList<Card>();
  static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
  static String[] faceValue = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
  int[] gameValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

  public static ArrayList<Card> makeCards(){

    for(String suit : suits){
      for(String faceValue : faceValue){
        Card card = new Card(suit, faceValue, 1);
        deck.add(card);
      }
    }
  } 

}