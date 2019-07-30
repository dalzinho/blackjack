package cards.game;

import cards.deck.Deck;
import cards.game.blackjack.Blackjack;
import cards.game.highcard.HighCard;
import cards.output.CardsGui;
import cards.player.Player;

public class GameFactory {

    private final Player player1;
    private final Player player2;
    private final Deck deck;
    private CardsGui cardsGui;

    public GameFactory(Player player1, Player player2, Deck deck, CardsGui cardsGui) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
        this.cardsGui = cardsGui;
    }

    public Game selectGame() {
        Game game;

        cardsGui.display("Would you like '(b)lackjack' or '(h)igh card'?");
        char selection = cardsGui.readCharFromCommandLine();

        if (selection == 'b') {
            game = new Blackjack(player1, player2, deck, cardsGui);
        } else if (selection =='h') {
            game = new HighCard(player1, player2, deck, cardsGui);
        } else {
            cardsGui.display("error");
            return selectGame();
        }
        return game;
    }




}
