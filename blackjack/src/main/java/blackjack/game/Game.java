package blackjack.game;

import blackjack.deck.Card;
import blackjack.deck.Deck;
import blackjack.player.Player;
import blackjack.output.BlackjackGui;

import static blackjack.game.ScoreEvaluator.evaluateHand;
import static blackjack.game.ScoreEvaluator.getResult;

public class Game {

  public static final char TWIST = 't';
  public static final char STICK = 's';
  private final Player player1;
  private final Player player2;
  private final Deck deck;
  private final BlackjackGui blackjackOutput;

  public Game(Player player1, Player player2, Deck deck, BlackjackGui blackjackOutput) {
    this.player1 = player1;
    this.player2 = player2;
    this.deck = deck;
    this.blackjackOutput = blackjackOutput;
  }

  public void start(){
    deal();
    takeTurn(player1);
    takeTurn(player2);
    blackjackOutput.display(getResult(player1, player2));
  }

  private void deal() {
    player1.addCardToHand(deck.removeCard());
    player2.addCardToHand(deck.removeCard());
    player1.addCardToHand(deck.removeCard());
    player2.addCardToHand(deck.removeCard());
  }

  private void takeTurn(Player player){
    blackjackOutput.displayBold("Ready " + player.getName());
    blackjackOutput.display(player.getStatus());
    blackjackOutput.display(evaluateHand(player));

    while (!player.isBust() && !player.hasTwentyOne()){
      blackjackOutput.display("Would you like to (S)tick or (T)wist?");

      char response = blackjackOutput.twistOrStick();

      if(response == TWIST){
        Card nextCard = deck.removeCard();
        player.addCardToHand(nextCard);
        blackjackOutput.display("You get the " + nextCard.prettyName());
        blackjackOutput.display(player.getStatus());
      }
      else if(response == STICK){
        break;
      }
    }
    blackjackOutput.display(evaluateHand(player));
  }
}
