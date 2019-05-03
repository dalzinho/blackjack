package blackjack.deck;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.enums.EnumUtils;

import static blackjack.deck.FaceValue.ACE;

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

  //this is an odd behaviour for a playing card, granted. It's just there to help with some of the tests! Call it an easter egg :)
  public String squeak(){
    return "squeak";
  }

  public boolean isAce() {
    return this.faceValue == ACE;
  }

}