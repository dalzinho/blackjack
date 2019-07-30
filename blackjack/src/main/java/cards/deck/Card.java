package cards.deck;

import static cards.deck.FaceValue.ACE;

public class Card {
  private Suit suit;
  private FaceValue faceValue;

  public Card(Suit suit, FaceValue faceValue){
    this.suit = suit;
    this.faceValue = faceValue;
  }

  public FaceValue getFaceValue(){
    return this.faceValue;
  }

  public String prettyName(){
    return EnumUtil.prettify(this.faceValue)
            + " of " +
            EnumUtil.prettify(this.suit);
  }

  public int getGameValue(){
    return this.faceValue.getGameValue();
  }

  public boolean isAce() {
    return this.faceValue == ACE;
  }

}