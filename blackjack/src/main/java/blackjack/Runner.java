package blackjack;

import blackjack.deck.Deck;
import blackjack.game.Game;
import blackjack.player.Player;
import blackjack.output.BlackjackGui;
import blackjack.output.StdOutPrinter;

public class Runner{

  public static void main(String[] args) {
    Deck deck = Deck.buildDeck();
    Player player1 = new Player("Player One");
    Player player2 = new Player("Player Two");
    BlackjackGui console = new StdOutPrinter();

    new Game(player1, player2, deck, console).start();
  }
}