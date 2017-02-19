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
    // if (player.evaluateHandForNotBust()){
    //   result = "This player has: " + player.showCardsHeld();
    // }
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

  public void takeTurn(Player player, Console console, Deck deck){
    console.display(evaluateHand(player));

    while (player.evaluateHandForNotBust() == true && player.evaluateHandForWin() == false){
      console.display("Would you like to (S)tick or (T)wist?");
      

      // ask console to return T or S
      char response = console.twistOrStick();
      //if response == T carry out taking a card and re-evaluating
      if(response == 't'){
        player.takeCard(deck);
        console.display("You get the " + player.getLastCardInHand().prettyName() + ". Total Score: " + player.getCardsTotalValue());
      }
      else if(response == 's'){
        break;
      }
      // else pass game to player two, leaving card total value intact. Break loop somehow, or change a variable in player?
    }
    console.display(evaluateHand(player));
  }

  public void start(Player player1, Player player2, Deck deck, Console console){
    player1.takeCard(deck);
    player2.takeCard(deck);
    player1.takeCard(deck);
    player2.takeCard(deck);

    console.display("====================");
    console.display("| READY PLAYER ONE |");
    console.display("====================");
    console.display(player1.showCardsHeld());
    takeTurn(player1, console, deck);

    console.display("====================");
    console.display("| READY PLAYER TWO |");
    console.display("====================");
    console.display(player2.showCardsHeld());
    takeTurn(player2, console, deck);

    int p1Score = player1.getCardsTotalValue();
    int p2Score = player2.getCardsTotalValue();

    if (p1Score > 21 && p2Score > 21){
      result = "you are both BUST!";
    }
    else if (p1Score > 21 && p2Score <= 21){
      result = "Player Two wins!";
    }

    else if (p1Score <= 21 && p2Score > 21){
      result = "Player One Wins!";
    }

    else {
      result = decide(p1Score, p2Score);
    }
    console.display(result);
  }
}
