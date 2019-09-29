package cards.game.highcard;

import cards.deck.Deck;
import cards.game.Game;
import cards.output.CardsGui;
import cards.output.SysInReader;
import cards.player.Player;

public class HighCard extends Game {

  public HighCard(Player player1, Player player2, Deck deck, CardsGui console, SysInReader sysInReader){
    super(player1, player2, deck, console, sysInReader);
  }

  @Override
  public void start() {
    player1.addCardToHand(deck.removeCard());
    console.display(player1.getStatus());
    player2.addCardToHand(deck.removeCard());
    console.display(player2.getStatus());
    String result = decide(player1.getHandValue(), player2.getHandValue());
    console.display(result);
  }

  private String decide(int p1Score, int p2Score){
    String result;

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
} 