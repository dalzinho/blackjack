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

  public void start(Player player1, Player player2, Deck deck, Console console){
      player1.takeCard(deck);
      player2.takeCard(deck);
      player1.takeCard(deck);
      player2.takeCard(deck);
      console.display("Player One has: " + player1.showCardsHeld());
      console.display("Player Two has: " + player2.showCardsHeld());
      result = decide(player1.getCardsTotalValue(), player2.getCardsTotalValue());
      console.display(result);
  }
} 