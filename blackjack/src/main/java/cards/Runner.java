package cards;

import cards.deck.Deck;
import cards.deck.DeckException;
import cards.game.GameFactory;
import cards.hand.Hand;
import cards.output.CardsGui;
import cards.output.StdOutPrinter;
import cards.player.Player;

public class Runner{

  public static void main(String[] args) {
    Deck deck = Deck.buildDeck();
    Player player1 = new Player("Player One", new Hand());
    Player player2 = new Player("Player Two", new Hand());
    CardsGui console = new StdOutPrinter();

      GameFactory gameFactory = new GameFactory(player1, player2, deck, console);

      boolean loopActive = true;

      while (loopActive) {
          try {
              gameFactory.selectGame().start();

              player1.clearHand();
              player2.clearHand();
          } catch (DeckException e) {
              console.display(e.getMessage());
              console.display("cheerio");
              loopActive = false;
          }
    }
  }
}