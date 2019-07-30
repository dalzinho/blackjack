package cards.game;

import cards.deck.Deck;
import cards.output.CardsGui;
import cards.player.Player;

public abstract class Game {

    protected final Player player1;
    protected final Player player2;
    protected final Deck deck;
    protected final CardsGui console;

    public Game(Player player1, Player player2, Deck deck, CardsGui console){
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
        this.console = console;
    }

    public abstract void start();
}
