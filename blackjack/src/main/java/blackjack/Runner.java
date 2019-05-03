package blackjack;

import blackjack.output.BlackjackGui;

public class Runner{

  public static void main(String[] args) {
    Deck deck = new Deck();
    Player player1 = new Player("Player One");
    Player player2 = new Player("Player Two");
    BlackjackGui console = new StdOutPrinter();

    new Game(player1, player2, deck, console).start();
  }
}