package cards.game;

import cards.deck.Deck;
import cards.deck.DeckException;
import cards.game.blackjack.Blackjack;
import cards.game.highcard.HighCard;
import cards.output.CardsGui;
import cards.output.SysInReader;
import cards.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class GameFactoryTest {

    @Mock
    Player player;

    @Mock
    Deck deck;

    @Mock
    CardsGui cardsGui;

    @Mock
    SysInReader sysInReader;

    @InjectMocks
    private GameFactory gameFactory = new GameFactory(player, player, deck, cardsGui, sysInReader);

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void selectGame_blackjack() {
        when(sysInReader.readCharFromCommandLine()).thenReturn('b');

        Game game = gameFactory.selectGame();
        assertTrue(game instanceof Blackjack);
    }

    @Test
    public void selectGame_highcard() {
        when(sysInReader.readCharFromCommandLine()).thenReturn('h');

        Game game = gameFactory.selectGame();
        assertTrue(game instanceof HighCard);
    }

    @Test(expected = DeckException.class)
    public void quitGameCommand_throwsException() {
        when(sysInReader.readCharFromCommandLine()).thenReturn('q');
        gameFactory.selectGame();
    }

    @Test(expected = DeckException.class)
    public void invalidCharacterEntry_logsMessage() {
        when(sysInReader.readCharFromCommandLine()).thenReturn('z');
        gameFactory.selectGame();
        verify(cardsGui, atLeastOnce()).display("error");
    }
}