package blackjack;

import blackjack.output.BlackjackGui;

public class Game {

  private final Player player1;
  private final Player player2;
  private final Deck deck;
  private final BlackjackGui blackjackOutput;
  private String result;

  public Game(Player player1, Player player2, Deck deck, BlackjackGui blackjackOutput) {
    this.player1 = player1;
    this.player2 = player2;
    this.deck = deck;
    this.blackjackOutput = blackjackOutput;
    result = "";
  }

  public String decide(int p1Score, int p2Score){
    if(p1Score > p2Score){
      result = "Player One wins!";
    }
    else if(p2Score > p1Score){
      result = "Player Two wins!";
    }
    else{
      result = "It's a Draw!";
    }

    return result;
  }

  public String evaluateHand(Player player){

    if(player.evaluateHandForWin()){
      result = "You have scored 21!";
    }
    else if(player.evaluateHandForLoss()){
      result = "You are BUST!";
    }
    else{
      result = "";
    }
    
    return result;
  }

  public void takeTurn(Player player){

    blackjackOutput.displayBold("Ready " + player.getName());
    blackjackOutput.display(player.showCardsHeld());
    
    blackjackOutput.display(evaluateHand(player));

    while (player.evaluateHandForNotBust() && !player.evaluateHandForWin()){
      blackjackOutput.display("Would you like to (S)tick or (T)wist?");
      

      // ask blackjackOutput to return T or S
      char response = blackjackOutput.twistOrStick();
      //if response == T carry out taking a card and re-evaluating
      if(response == 't'){
        player.takeCard(deck.removeCard());
        blackjackOutput.display("You get the " + player.getLastCardInHand().prettyName() + ". Total Score: " + player.getCardsTotalValue());
      }
      else if(response == 's'){
        break;
      }
      // else pass game to player two, leaving card total value intact. Break loop somehow, or change a variable in player?
    }
    blackjackOutput.display(evaluateHand(player));
  }

  public void start(){
    player1.takeCard(deck.removeCard());
    player2.takeCard(deck.removeCard());
    player1.takeCard(deck.removeCard());
    player2.takeCard(deck.removeCard());

    takeTurn(player1);
    takeTurn(player2);

    int p1Score = player1.getCardsTotalValue();
    int p2Score = player2.getCardsTotalValue();

    if (p1Score > 21 && p2Score > 21){
      result = "you are both BUST!";
    }
    else if (p1Score > 21) {
      result = "Player Two wins!";
    }

    else if (p2Score > 21){
      result = "Player One Wins!";
    }

    else {
      result = decide(p1Score, p2Score);
    }
    blackjackOutput.display(result);
  }
}
