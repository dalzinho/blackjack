package cards;

import cards.deck.Deck;
import cards.game.Game;
import cards.game.blackjack.Blackjack;
import cards.game.highcard.HighCard;
import cards.hand.Hand;
import cards.player.Player;
import cards.output.CardsGui;
import cards.output.StdOutPrinter;

public class Runner{

  public static void main(String[] args) {
    Deck deck = Deck.buildDeck();
    Player player1 = new Player("Player One", new Hand());
    Player player2 = new Player("Player Two", new Hand());
    CardsGui console = new StdOutPrinter();

      Game blackjack = new Blackjack(player1, player2, deck, console);

      blackjack.start();
      player1.clearHand();
      player2.clearHand();
      deck = Deck.buildDeck();

      Game highCard = new HighCard(player1, player2, deck, console);
      highCard.start();
  }
}