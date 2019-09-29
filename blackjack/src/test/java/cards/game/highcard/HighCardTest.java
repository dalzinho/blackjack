package cards.game.highcard;

import cards.deck.Deck;
import cards.output.CardsGui;
import cards.output.SysInReader;
import cards.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class HighCardTest {

    @Mock
    Deck deck;

    @Mock
    Player player1;

    @Mock
    Player player2;

    @Mock
    CardsGui cardsGui;

    @Mock
    SysInReader sysInReader;

    @InjectMocks
    HighCard highCard;

    @Before
    public void setup() {
        highCard = new HighCard(player1, player2, deck, cardsGui, sysInReader);
        initMocks(this);
    }

    @Test
    public void playerOneHasAce_playerTwoHasTwo_p1Wins() {
        when(player1.getHandValue()).thenReturn(13);
        when(player2.getHandValue()).thenReturn(2);
        highCard.start();
        verify(cardsGui, times(1)).display("Player One wins!");
    }

    @Test
    public void playerTwoHasAce_playerOneHasTwo_p2Wins() {
        when(player1.getHandValue()).thenReturn(2);
        when(player2.getHandValue()).thenReturn(3);
        highCard.start();
        verify(cardsGui, times(1)).display("Player Two wins!");
    }

    @Test
    public void isADraw() {
        when(player1.getHandValue()).thenReturn(2);
        when(player2.getHandValue()).thenReturn(2);
        highCard.start();
        verify(cardsGui, times(1)).display("It's a Draw!");
    }
}