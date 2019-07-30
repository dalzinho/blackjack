package highcard;

import cards.deck.Deck;
import cards.game.highcard.HighCard;
import cards.hand.Hand;
import cards.output.CardsGui;
import cards.output.StdOutPrinter;
import cards.player.Player;

public class Runner{

  public static void main(String[] args) {
    Deck deck = Deck.buildDeck();
    Player player1 = new Player("player1", new Hand());
    Player player2 = new Player("player2", new Hand());
    CardsGui console = new StdOutPrinter();
    new HighCard(player1, player2, deck, console).start();
  }
}