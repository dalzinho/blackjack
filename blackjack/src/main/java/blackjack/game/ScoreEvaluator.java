package blackjack.game;

import blackjack.player.Player;

public class ScoreEvaluator {

    private ScoreEvaluator() {}

    public static String getResult(Player p1, Player p2) {
        String result;

        if (p1.isBust() && p2.isBust()){
            result = "you are both BUST!";
        }
        else if (p1.isBust()) {
            result = "Player Two wins!";
        }

        else if (p2.isBust()){
            result = "Player One Wins!";
        }

        else {
            result = evaluteOnScore(p1.getCardsTotalValue(), p2.getCardsTotalValue());
        }

        return result;
    }

    private static String evaluteOnScore(int p1Score, int p2Score) {
        String result;

        if(p1Score > p2Score){
            result = "Player One wins!";
        }
        else if(p2Score > p1Score){
            result = "Player Two wins!";
        }
        else{
            result = "It's a Draw!";
        }

        return result;
    }

    public static String evaluateHand(Player player){
        String result = "";

        if(player.hasTwentyOne()){
            result = "You have scored 21!";
        }
        else if(player.isBust()){
            result = "You are BUST!";
        }

        return result;
    }
}
