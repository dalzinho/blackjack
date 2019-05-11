package blackjack.game;

import blackjack.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static blackjack.game.ResultType.*;
import static blackjack.game.ScoreEvaluator.evaluateHand;
import static blackjack.game.ScoreEvaluator.getResult;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ScoreEvaluatorTest {

    @Mock
    Player player1;

    @Mock
    Player player2;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void getResultForBothBust() {
        when(player1.isBust()).thenReturn(true);
        when(player2.isBust()).thenReturn(true);
        String result = getResult(player1, player2);
        assertEquals(BUST_DRAW.getMessage(), result);
    }

    @Test
    public void getResultForP1BustP2Good() {
        when(player1.isBust()).thenReturn(true);
        when(player2.isBust()).thenReturn(false);
        String result = getResult(player1, player2);
        assertEquals(P2_WIN.getMessage(), result);
    }

    @Test
    public void getResultForP2BustP1Good() {
        when(player1.isBust()).thenReturn(false);
        when(player2.isBust()).thenReturn(true);
        String result = getResult(player1, player2);
        assertEquals(P1_WIN.getMessage(), result);
    }

    @Test
    public void getResultForScoreDraw() {
        when(player1.isBust()).thenReturn(false);
        when(player2.isBust()).thenReturn(false);
        when(player1.getCardsTotalValue()).thenReturn(10);
        when(player2.getCardsTotalValue()).thenReturn(10);
        String result = getResult(player1, player2);
        assertEquals(SCORE_DRAW.getMessage(), result);
    }

    @Test
    public void testP1ScoreGreaterThanP2() {
        when(player1.isBust()).thenReturn(false);
        when(player2.isBust()).thenReturn(false);
        when(player1.getCardsTotalValue()).thenReturn(11);
        when(player2.getCardsTotalValue()).thenReturn(10);
        String result = getResult(player1, player2);
        assertEquals(P1_WIN.getMessage(), result);
    }

    @Test
    public void testP2ScoreGreaterThanP1() {
        when(player1.isBust()).thenReturn(false);
        when(player2.isBust()).thenReturn(false);
        when(player1.getCardsTotalValue()).thenReturn(11);
        when(player2.getCardsTotalValue()).thenReturn(21);
        String result = getResult(player1, player2);
        assertEquals(P2_WIN.getMessage(), result);
    }

    @Test
    public void evaluateTwentyOneHand() {
        when(player1.hasTwentyOne()).thenReturn(true);
        String result = evaluateHand(player1);
        assertEquals(PLAYER_HAS_21.getMessage(), result);
    }

    @Test
    public void evaluateBustHand() {
        when(player1.isBust()).thenReturn(true);
        String result = evaluateHand(player1);
        assertEquals(PLAYER_BUST.getMessage(), result);
    }

    @Test
    public void evaluateValidHand() {
        String result = evaluateHand(player1);
        assertTrue(result.isBlank());
    }
}