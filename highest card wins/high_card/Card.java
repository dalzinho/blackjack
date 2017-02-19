package high_card;

public class Card {
  String suit;
  String faceValue;
  int gameValue;

  public Card(String suit, String faceValue, int gameValue){
    this.suit = suit;
    this.faceValue = faceValue;
    this.gameValue = gameValue;
  }

  public String getFaceValue(){
    return this.faceValue;
  }

  public String prettyName(){
    return this.faceValue + " of " + this.suit;
  }

  public int getGameValue(){
    return this.gameValue;
  }

  public void setGameValue(int gv){
    this.gameValue = gv;
  }

  //this is an odd behaviour for a playing card, granted. It's just there to help with some of the tests! Call it an easter egg :)
  public String squeak(){
    return "squeak";
  }

}