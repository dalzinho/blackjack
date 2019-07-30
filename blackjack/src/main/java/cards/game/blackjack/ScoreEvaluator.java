package cards.game.blackjack;

import cards.player.Player;

import static cards.game.blackjack.ResultType.*;

public class ScoreEvaluator {

    private ScoreEvaluator() {
    }

    public static String getResult(Player p1, Player p2) {
        ResultType result;

        if (p1.isBust() && p2.isBust()) {
            result = BUST_DRAW;
        } else if (p1.isBust()) {
            result = P2_WIN;
        } else if (p2.isBust()) {
            result = P1_WIN;
        } else {
            result = evaluteOnScore(p1.getHandValue(), p2.getHandValue());
        }

        return result.getMessage();
    }

    private static ResultType evaluteOnScore(int p1Score, int p2Score) {
        ResultType result;

        if (p1Score > p2Score) {
            result = P1_WIN;
        } else if (p2Score > p1Score) {
            result = P2_WIN;
        } else {
            result = SCORE_DRAW;
        }

        return result;
    }

    public static String evaluateHand(Player player) {
        String result = "";

        if (player.hasTwentyOne()) {
            result = PLAYER_HAS_21.getMessage();
        } else if (player.isBust()) {
            result = PLAYER_BUST.getMessage();
        }

        return result;
    }
}
