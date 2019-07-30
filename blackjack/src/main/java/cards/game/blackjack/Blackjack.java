package cards.game.blackjack;

import cards.deck.Card;
import cards.deck.Deck;
import cards.game.Game;
import cards.player.Player;
import cards.output.CardsGui;

import static cards.game.blackjack.ScoreEvaluator.evaluateHand;
import static cards.game.blackjack.ScoreEvaluator.getResult;

public class Blackjack extends Game {

  private static final char TWIST = 't';
  private static final char STICK = 's';

  public Blackjack(Player player1, Player player2, Deck deck, CardsGui console) {
    super(player1, player2, deck, console);
  }

  @Override
  public void start(){
    deal();
    takeTurn(player1);
    takeTurn(player2);
    console.display(getResult(player1, player2));
  }

  private void deal() {
    player1.addCardToHand(deck.removeCard());
    player2.addCardToHand(deck.removeCard());
    player1.addCardToHand(deck.removeCard());
    player2.addCardToHand(deck.removeCard());
  }

  private void takeTurn(Player player){
    console.displayBold("Ready " + player.getName());
    console.display(player.getStatus());
    console.display(evaluateHand(player));

    while (!player.isBust() && !player.hasTwentyOne()){
      console.display("Would you like to (S)tick or (T)wist?");

      char response = console.twistOrStick();

      if(response == TWIST){
        Card nextCard = deck.removeCard();
        player.addCardToHand(nextCard);
        console.display("You get the " + nextCard.prettyName());
        console.display(player.getStatus());
      }
      else if(response == STICK){
        break;
      }
    }
    console.display(evaluateHand(player));
  }
}
