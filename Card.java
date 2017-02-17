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

  public int gameValue(){
    return this.gameValue;
  }

  public void setGameValue(int gv){
    this.gameValue = gv;
  }

  public String squeak(){
    return "squeak";
  }

}