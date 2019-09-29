package cards.game;

import cards.deck.Deck;
import cards.deck.DeckException;
import cards.game.blackjack.Blackjack;
import cards.game.highcard.HighCard;
import cards.output.CardsGui;
import cards.output.SysInReader;
import cards.player.Player;

public class GameFactory {

    private final Player player1;
    private final Player player2;
    private final Deck deck;
    private CardsGui cardsGui;
    private SysInReader sysInReader;

    private int retryCount;

    public GameFactory(Player player1, Player player2, Deck deck, CardsGui cardsGui, SysInReader sysInReader) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
        this.cardsGui = cardsGui;
        this.sysInReader = sysInReader;
    }

    public Game selectGame() {
        if (retryCount >= 3) {
            throw new DeckException("user is too daft to play");
        }

        Game game;

        cardsGui.display("Would you like '(b)lackjack' or '(h)igh card'?");
        char selection = sysInReader.readCharFromCommandLine();

        if (selection == 'b') {
            game = new Blackjack(player1, player2, deck, cardsGui, sysInReader);
        } else if (selection =='h') {
            game = new HighCard(player1, player2, deck, cardsGui, sysInReader);
        } else if (selection == 'q') {
            throw new DeckException("user disnae want to play any more");
        } else {
            retryCount++;
            cardsGui.display("error");
            return selectGame();
        }

        return game;
    }




}
