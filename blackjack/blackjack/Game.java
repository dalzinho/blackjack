package blackjack;

public class Game {

  String result;

  public Game(){
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
      result = "Would you like to (S)tick or (T)wist?";
    }
    return result;
  }


  public void start(Player player1, Player player2, Deck deck, Console console){
      player1.takeCard(deck);
      player2.takeCard(deck);
      player1.takeCard(deck);
      player2.takeCard(deck);
      console.display("Player One has: " + player1.showCardsHeld());
      console.display(evaluateHand(player1));
      while(player1.evaluateHandForNotBust() == true){
        player1.takeCard(deck);
        console.display("You get the " + player1.getLastCardInHand().prettyName() + ". Total Score: " + player1.getCardsTotalValue());
      }
      console.display(evaluateHand(player1));
  }
} 