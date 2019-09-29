package cards.game;

import cards.deck.Deck;
import cards.output.CardsGui;
import cards.output.SysInReader;
import cards.player.Player;

public abstract class Game {

    protected Player player1;
    protected Player player2;
    protected Deck deck;
    protected CardsGui console;
    protected SysInReader sysInReader;

    public Game(Player player1, Player player2, Deck deck, CardsGui console, SysInReader sysInReader) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
        this.console = console;
        this.sysInReader = sysInReader;
    }

    public abstract void start();
}
